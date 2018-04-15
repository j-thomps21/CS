#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <sys/signal.h>


int count = 0;

void handler(int signum){

  printf("You Shot Me!\n");
  count++;

  if(count > 3){
    printf("I'm dead!\n");
    exit(1);
  }

}

int main(){

  //establish signal hander for SIGTINT and SIGSTOP
  signal(SIGINT,handler);
  signal(SIGTSTP,handler);

  //loop forever
  while(1);

}
