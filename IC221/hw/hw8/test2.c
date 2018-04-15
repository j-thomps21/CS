#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/syscall.h>
#include <sys/wait.h>

int main(){
  pid_t cpid;

  cpid = fork();
  if(cpid == 0){

    setpgrp();
    if( getpid() == getpgrp()){
      printf("C: SAME PGID\n");
    }
    exit(0);

  }else if(cpid > 0){

    if(getpgid(cpid) == cpid){
      printf("P: SAME PGID\n");
    }else{
      printf("P: NOT SAME PGID\n");
    }

    wait(NULL);
    exit(0);
  }

  exit(1);
}
