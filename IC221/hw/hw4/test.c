#include <stdio.h>
#include <string.h>

int main( int argc, char *argv[]){
char ** curarg;
int i=0;
printf("argc = %d\n", argc);
 for( curarg=argv; *curarg ; curarg++){
   int n;
   if(sscanf(argv[i], "%d", &n) == 0)
     printf("argv[%d] = %s (is *NOT* a number!)\n", i++, *curarg);
   else
     printf("argv[%d] = %s (is a number!)\n", i++, *curarg);
 }
}
