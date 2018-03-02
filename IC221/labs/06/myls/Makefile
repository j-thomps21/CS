#TODO:
# -- Don't forget you need to compile with the -lbsd option for myls
# -- gcc -lbsd -g -Wall myls.c -o myls

all:  myls

myls: myls.c
		gcc myls.c -g -Wall -o myls -lbsd

clean:
		rm -f myls
