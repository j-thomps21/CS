#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <time.h>

int main(int argc, char *argv[])
{
  struct timeval tv;
  gettimeofday(&tv, NULL);
  printf("%s\n", ctime(&(tv.tv_sec)));
  return 0;
}
