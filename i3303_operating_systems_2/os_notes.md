# Chapter 0: Processes Revision

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
# Chapter 1: Executing a file


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


