#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

typedef struct
{
  long acctnum;
  double bal;
  char acctname[1024];
} acct_t;

void read_accts(acct_t** accts, char* fname)
{
  int fd;
  fd = open(fname, O_RDONLY);
  read(fd, &accts, 1000*sizeof(acct_t));
  close(fd);
}

int main(int argc, char *argv[]) {
  acct_t* accts;
  read_accts(&accts, argv[1]);

  int i;
  for(i = 0; i < 1000; i++)
  {
    printf("%ld (%f) -- %s\n", accts[i].acctnum, accts[i].bal, accts[i].acctname);
  }
  return 0;
}
