# Chapter 0: Revision

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