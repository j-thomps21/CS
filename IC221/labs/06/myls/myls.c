#include <dirent.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <bsd/string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/errno.h>
#include <time.h>
#include <pwd.h>
#include <pwd.h>
#include <grp.h>


int main(int argc, char * argv[]){

  //directory navigation variables
  DIR * dir_p;
  struct dirent * entry;

  //listing variables
  struct stat filestat;
  struct passwd * pwd;
  struct group * grp;
  char mode_str[12];

  //open the directory to read each of the entries
  if( (dir_p = opendir(".")) == NULL){
    fprintf(stderr, "ERROR: diropen: %s\n", strerror(errno));
    return 1;
  }

  //foreach entry in the directory
  while( NULL != (entry = readdir(dir_p)) )
  {

    //Name of current file is entry->d_name
    stat(entry->d_name, &filestat);

    strmode(filestat.st_mode, mode_str);
    pwd = getpwuid(filestat.st_uid);
    grp = getgrgid(filestat.st_gid);
    //You can call stat(entr->d_name, ....) like so
    printf("%s\t%s\t%s\t%s\t%ld\t%s", mode_str, entry->d_name, pwd->pw_name,  grp->gr_name,filestat.st_size, (ctime(&(filestat.st_mtime))));
    //TODO Complete the listing for each entry

  }

  //close the directory
  closedir(dir_p);
}
