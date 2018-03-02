#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/errno.h>
#include <fcntl.h>

#define BUFFSIZE 4096

int getFD(char* fname);
int makeNew(char* fname);

int main(int argc, char * argv[]){
  if( argc < 2)
  {
    fprintf(stderr, "ERROR: Require files\n");
    return 2;
  }
  struct stat st;
  if(stat(argv[1], &st) < 0)
  {
    perror(argv[1]);
    return 2;
  }
  if(S_ISDIR(st.st_mode))
  {
    fprintf(stderr, "%s: %s: Is a directory\n", argv[0], argv[1]);
    return 1;
  }

  //Variable Declaration
  char buf[BUFFSIZE];
  int n, m;
  int fd_src, fd_dest;
  struct stat fs;

  fd_src = open(argv[1], O_RDONLY);
  if(fd_src < 0)
  {
    perror(argv[1]);
    return 2;
  }
  fd_dest = open(argv[2], O_WRONLY | O_TRUNC | O_CREAT, 0640);
  if(fd_dest < 0)
  {
    perror(argv[2]);
  }

  if(fstat(fd_src, &fs) < 0)
  {
    perror(argv[1]);
    return 2;
  }
  do{

    m = read(fd_src, buf, BUFFSIZE);
    if(m < 0)
    {
      perror(argv[1]);
      return 2;
    }
    n = write(fd_dest, buf, m);
    if(n < 0)
    {
      perror(argv[2]);
      return 2;
    }
  }while( m != 0);
  fchmod(fd_dest, 0640);
  return 0;
}
