// Prompt
// Write a program that determines the maximum of a vector of integers by distributing the task between a parent process and his child.

#include<stdlib.h>
#include<sys/wait.h>
#include<unistd.h>
#include<stdio.h>
#include<malloc.h>

int main(){
        int a = 0, n = 0, temp = 0;
        scanf("%d", &n);
        int *arr = (int *)malloc(n * sizeof(int));
        for (int i = 0; i < n; i++) scanf("%d", arr + i);
        if (fork()) n = n/2;
        else a = n/2 + 1;
        temp = *arr;
        for (int i = a; i < n; i++)
                if (temp > *(arr + i)) temp = *(arr + i);
        if (a != 0) exit(temp);
        wait(&a);
        if (a > temp) temp = a;
        printf("The biggest value is %d", temp);
        return 0;
}