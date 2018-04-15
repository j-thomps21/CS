#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/syscall.h>
#include <sys/wait.h>
#include <string.h>

int main(){
  pid_t cpid;
  int pfd[2], n;
  char gonavy[] = "Go Navy!";
  char buffer[1024];

  pipe(pfd);

  cpid = fork();
  if( cpid == 0 )
  {
    close(1);
    dup2(pfd[1], 1);
    close(pfd[0]);

    write(1, gonavy,strlen(gonavy));
  }
  else if( cpid > 0 )
  {
    close(0);
    dup2(pfd[0], 0);
    close(pfd[1]);

    
    n = read(0, buffer, 1024);
    write(1,buffer,n);
  }

  exit(1);
}
