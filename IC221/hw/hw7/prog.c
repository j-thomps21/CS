#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char *argv[])
{
  pid_t cid;
  char * ls_args[] = {"/bin/ls", NULL, NULL};
  if(argc == 2)
    ls_args[1] = argv[1];
  cid = fork();

  if( cid == 0)
  {
    execv(ls_args[0], ls_args);
  }
  else if(cid > 0)
  {
    int status, t;
    t = wait(&status);

    if(WEXITSTATUS(status) == 0)
      printf("EXISTS!\n");
    else if(WEXITSTATUS(status) == 2)
      printf("DOES NOT EXIST!\n");
  }
  return 0;
}
