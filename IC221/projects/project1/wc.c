#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int wordCount(FILE* fin);
FILE** loadFILES(char** argv, int argc);
int charCountTotal();
int charCountString();
FILE* initFile();


int main(int argc, char *argv[])
{
  if(argc == 1)
  {
    printf("You fucked up bitch\n");
    exit(1);
  }

  FILE** finArray = loadFILES(argv, argc);     //Array of fin for reading files


  printf("%s has %d words!\n", argv[1], wordCount(finArray[0]));

  return 0;
}



//////////////////////////////////////////
FILE** loadFILES(char** argv, int argc)
{
  int i;
  FILE** finArray = (FILE**)calloc(argc-1, sizeof(FILE*));

  for(i = 1; i < argc; i++)
  {
    finArray[i-1] = initFile(argv[i]);
  }
  return finArray;
}
//////////////////////////////////////////
int wordCount(FILE* fin)
{
  int wcount = 0;
  while(fin != NULL)
  {
    char c[100];
    fscanf(fin, "%s", c);
    wcount++;
  }
  return wcount;
}
//////////////////////////////////////////
FILE* initFile(char* in)
{
  FILE* fin;
  if( (fin = fopen(in, "r")) == NULL)
  {
    printf("You done ducked up bih\n");
    exit(1);
  }
  else
  {
    return fin;
  }
}
//////////////////////////////////////////
