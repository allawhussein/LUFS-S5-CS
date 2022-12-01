// Prompt
// Write a program that determines the maximum of a vector of integers by distributing the task between a parent process and his child.

#include<stdlib.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>
#include<malloc.h>

int main(){
        int a = 0, n = 0, temp = 0;
        printf("This program get the maximum number by dividing the search task between two process\n");
        printf("parent PID: %d\n", getpid());
        printf("enter the size of the input: ");
        scanf("%d", &n);
        int *arr = (int *)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++) scanf("%d", arr + i);
        if (fork()) n = n/2 + 1;
        else a = n/2 + 1;
        temp = *arr;
        for (int i = a; i < n; i++){
                if (temp < *(arr + i)) temp = *(arr + i);
                printf("process %d processed number %d\n", getpid(), *(arr+i));
        }
        if (a != 0) exit(temp);
        wait(&a);
        a = a >> 8;
        printf("forked process biggest number is %d\n", a);
        if (temp < a) temp = a;
        printf("The biggest value is %d", temp);
        return 0;
}