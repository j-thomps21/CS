#include <dirent.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <bsd/string.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/errno.h>
#include <time.h>
#include <pwd.h>
#include <pwd.h>
#include <grp.h>

int main(int argc, char *argv[])
{
  char smode[12];

  strmode(0644, smode);
  printf("0644: %s\n", smode);

  strmode(0742, smode);
  printf("0742: %s\n", smode);
  return 0;
}
