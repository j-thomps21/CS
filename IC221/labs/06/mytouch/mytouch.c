#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

int main(int argc, char *argv[]){

  //variable decleration
  struct stat sb;
  struct timeval tv[2];

  if(stat(argv[1], &sb) < 0)
  {
    perror(argv[1]);
    return 2;
  }

  printf("Last modified: %s", ctime(&(sb.st_mtime)));
  gettimeofday(tv, NULL);
  utimes(argv[1], NULL);
  printf("Last modified: %s", ctime(&(tv->tv_sec)));
  //TODO: Complete the touch operation

  return 0;
}
