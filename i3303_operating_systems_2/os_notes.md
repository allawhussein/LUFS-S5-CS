<h1 style="font-size:40px;border-bottom: solid 5px">Part I: Interprocess Communication</h1>

1. Wait & Exit
2. Unix Pipes
3. Signals
4. Shared memeory segment
5. communication by sockets

# Chapter 1: Wait & Exit

## view current process
```zsh    
$ ps
```
process of pid 1 is the "init" process.

## fork
```C
fork();
```

in the child process the function returns zero. in the parent process the function returns child pid or -1 if the fork process failed.  
While the child is a copy of the parent, with independent variables, files are shared between the processes, this is because the file is accessed through a shared link provided by the OS.

## Process Identification
```C
int getpid(); // returns the id of the process calling it
int getppid(); //returns the id of the parent of the process calling it
```
A process is called:
- an orphan if its parent died before it, in such case the process is adopted by `init` process of pid $0$.
- a zombie, if it exited, but its row haven't been remove from the OS PCB by the parent.


## exit
```C
void exit(int status) // <sys/wait.h>
```
The process calling `exit()` end its execution, and it may be used to inform the parent about the exit status, by convention `exit(0)` signals normal exit. The status value $\in [0, 255]$.

This function doesn't clear the process row from the OS PCB.

## wait
```C
int wait(int *st);
// the function is called by the parent to wait the exit of this child
// this is a blocking statement
// it returns the id of exiting child
// for one child only

int waitPid(int pid, int *st, int options);
// setting pid to -1 will make this function equivelant to wait(...)
// if option is set to WNOHANG (is is a defined macro), the parent shouldn't wait for the child to terminate.
// the default for option is 0
```

When any of the above functions is called, the process's row will be cleared from the PCB.

### Extracting status value of exited process
The st value modified by `wait()` or `waitPid()` is full int, thus 4 bytes, however the status value is only 1 byte and it is the second byte from the right, thus to isolate it we need to do a bit shifting
```C
int raw_status = 0;
wait(&raw_status)
int status_value = raw_status>>8;
```
Another method is using `int WIFEXITED(int status)` macro which returns non-zero value if the child terminated noramlly with exit, the returned value has no significance. This function should be called after calling `wait(&status)`. We also have `int WEXITSTATUS(int status)` macro, which returns the exit value. This function should be called after calling `wait(&status)`.
```C
int status = 0;
wait(&status);
if (IFWEXITED(status)){
    printf("The child exited normally, with return value %d", WEXITSTATUS(status));
}
```
The process can be terminated by `exit(status);` or it can be killed by another process, in such case we can benefit from `int WIFSIGNALED(int status);`, it returns a non-zero value if the child terminated because it received a signal that wasn't handled. Other wise if the kill signal was handled we can use `int WTERMSIG(int status)`

## sleep
A blocking statement for a given amount of time.
```C
int sleep(int sleep_seconds);
```
## Executing a file


How to change the main task of the created process to antoher task

family of exec functions: these functions are used to replace the current context of a processs with new image the running executable is now replaced completely by the called file executable.

1. `execl`  
```C
//execute a list
int execl(char *filename, char *arg_0, char *arg_1, ...);
// if the returned number is 0 then success, else if -1 failure.
// the last argument should be NULL, and arg_0 could be NULL if we wish to provide no arguments.
```
2. `execlp`  
```C
int execlp(char *filename, char *argv, char *argv, ...);
// similar to execl but will also look for commands in the PATH variable.
```

The functions can either return 0 for success, or -1 for failure. However note that success is useful for the OS only as the caller process is replace by the callee process, failure is also useless, as adding failure handling code after the `execl` will be executed anyways in case of failure.

**Example**: write a  program to execute the command `ls -l -a`

```C
void main (int argc, char *argv[]){
    int pid;
    pid = fork();
    if (!pid){
        execl("/bin/ls", "ls", "-l", "-a", NULL);
        // full path of the program to be executed is required
    }
}
```

```C
void main (int argc, char *argv[]){
    int pid;
    pid = fork();
    if (!pid){
        execlp("ls", "ls", "-l", "-a", NULL);
        // if program is in PATH, full path is not required.
    }
}
```

# Chapter 2: Unix Pipes
## Definition:
A pipe is an  IPC (interprocess communication) tool. It's a:  
- FIFO  buffer.
- One-way communicating tool
- The size of the pipe is fixed in the OS (hyperparameter of 4KB)
- the pipe has two sides for access: By convention, one is for reading, the other for writing
- the pipe is shared buffer along processes

It helps with communication and synchronization

## Pipe Creation
```C
int fd[2];
int pipe(fd); // creates a pipe
// fd[0] is the reading side
// fd[1] is the writing side
```
If the function returns `0` then the pipe was created successfully, if `-1` then the creation failed.

## I/O with Pipes
### writing
```C
int write(fd[1], buf, size);
```
we're writing into pipe fd, the content "buffer" of number of bytes "size".

### reading
```c
int read(fd[0], buf, size)
```

## Synchronization with pipes
The UNIX pipes are used as a tool of synchronization between processes by:
1. reading from empty pipe is a blocking statement if there's a writer on the other side
2. writing into a full pipe is a blocking statement if there's a reader on the other side.  

Any side can be determined if opened/closed by the descriptor of the side. This locking mechanism is useful for synchronizing by determining which process to execute and how much.

## Pipes and Forks
A pipe is useless for any single process. For the pipe to be used a tool of communication the pipe should be created before the forking action, otherwise each process will creates its own pipe that is inaccessible to the other process.

By default each created process is associated with a three file descriptors (everything in UNIX is a file):   
**0.** standard input (keyboard)
**1.** standard output (console screen)
**2.** standard error (also the console screen)

Thus for each process there's a table of file descriptors created, when a text file is opened through `int p = fopen("toto.txt", ...))`, this text file descriptor is added into the process table of file descriptors. And this's the reason we use the read/write functions we used previously with text files, both pipes and text files are files from the perspective of the UNIX OS.

A descriptor while similar to a pointer, it's not the same! we can have two different descriptors pointing to the same file.

```c
int main(){
    int pipeSide[2], pid, readStatus;
    char msgBfr[100]; // for receiving the message
    char *msg = "Hello another process";

    pipe(pipeSide);
    pid = fork();
    if (pid) { // parent proces
        // close the reading side.
        close(pipeSide[0]);
        write(pipeSide[1], msg, strlen(msg));
        close(pipeSide[1]);
    }
    else { // children process
        // close the writing side.
        close(pipeSide[1]);
        readStatus = read(pipeSide[0], msgBfr, 100);
        printf("The child read %d characters, content: %s", readStatus, msgBfr);
        close(pipeSide[0]);
    }

    return 0;
}
```

If two way communication is needed, we create two pipes in opposite direction.

```c
int main(){
    int paretToChild[2], childToParent, pid;
    pipe(parentToChild);
    pipe(childToParent);
    pid = fork();
    if (pid) { // parent proces
        // close the reading side of parentToChild pipe.
        // close the writing side of childToParent pipe.
    }
    else { // child process
        // close the writing side of parentToChild pipe.
        // close the reading side of childToParent pipe.
    }

    return 0;
}
```

## Exercises - From previous exams
```c
/* Exercise 1
Determine the output of following pseudo codes
*/

// code 1
void main(){
    int i, j = 1, p[2];
    pipe(p);
    write(p[1], &j, sizeof(int));
    for (i = 1; i < 5; i++){
        if (!fork()){
            close(P[1]);
            break;
        }
    }
    read(P[0], &j, sizeof(int));
    printf("%d\n", i);
}
/* code 1 analysis
the parent will fork four children, each having only the reading side of the pipe open, while the parent is having both sides open.

when we reach the reading statement there are two scenarios depending on who reaches the reading statement first,the first being one of the children, the second is the parent.

In the first scenario, this children will read the pipe and print its i, the rest of the process will be blocked as the pipe is empty and the pipe still have a writing side open. The exact output will be a single number between 1 and 4 inclusive.

In the second scenario the parent will read the pipe and exits.
when the children reach the reading statement, they'll encounter an empty pipe with no writing sides open, thus they'll be unblocked and continue execution directly. so the output will be 5 followed be 4 numbers with unknown order.
*/

// code 2
void main(){
    int i, j = 1, P[2];
    pipe(P);
    for (i = 1; i < 5; i++){
        if (!fork()){
            close(P[1]);
            break;
        }
    }
    wait(NULL);
    read(P[0], &j, sizeof(int));
    printf("%d\n", i);
}
/*
There's no output, all children are blocked by the read statement, and the parent will be blocked by the wait statement.
*/

// code 3
void main(){
    int i, j = 1, P[2];
    pipe(P);
    for (i = 1; i < 5; i++){
        if (!fork()){
            close(P[1]);
            break;
        }
    }
    write(P[1], &j, sizeof(int));
    printf("%d\n", i);
    read(P[0], &j, sizeof(int));
}
/*
5 + numbers [1, 4] in an unknown order
*/
```

# Chapter 3: Signals (IPC)

## Definition:
A signal is a "software interruption" defined to a process.

A software interruption is any interruption not initiated by a hardware including but not limited to OS itself, and drivers. A device initiate hardware interrupt, that will envoke a software interruption by the driver.

Upon signal delivery, an interrupt routine is started depending on the handler corresponding to the deliverd interrupt, these handlers are store in a "interruption vector".

Sources of signals are:
1. internal event  
like segmentation fault, division by zero, floating point error, ...
2. external event  
^C, ^Z (suspend event SIGSTP, 19), ^\, I/O status reporting, ...
3. explicit request  
a "KILL" signal
4. another process

Each signal has an ID or a macro (it is as simple as `#define <macro_name> <signal_id>`)

## Signal Reception

A process upon signal reception has to do one of the following:
1. ignore the signal if the signal can be ignored  
only few signals can safetly ignored (like child exit)
2. let the default action take place  
most of the default action is abort the program, `SIGSTP` `SIGKILL` can't be handled nor ignored
3. handle the signal if it can be handled

## Signal Handling

The `signal` function provides a simple interface for establishing an action for a particular signal.

```c
signal(<SIGID>, <handler>);
```

the handler argument takes a function name, having the function empty will override the default action of aborting the process.

The default action has a macro known as `SIG_DFL`, it is useful if we want to reset a signal's handler.  
Also there's `SIG_IGN` which will simply ignore the signal.

The `signal` function is of type `sighandler_t`, and it returns the previous value of the signal handler that has been replaced.


## Exmaple
```C
#include <signal.h>

int counter = 0;
void myhandler(int sig) {
    counter++;
}

void main() {
    int i;
    signal(SIGCHILD, myhandler);
    for (i = 0; i < 5; i++)
        if (!fork) exit(0);
    while (wait(NULL) != -1);
    printf("exited children: %d", counter);
}
```

