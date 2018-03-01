#include <stdio.h>

int main(int argc, char * argv[])
{
  FILE * stream;
  stream = fopen("file.txt", "w");
  fprintf(stream, "Hello World");
  fclose(stream);
  return 0;
}
