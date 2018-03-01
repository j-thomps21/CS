# TODO
# - runme.c depends on library.c
# - runme_too.c depend on library.c and fun.c

all: runme runme_too

runme: library.o runme.o
	 gcc library.o runme.o -o runme

runme_too: library.o runme_too.o fun.o
	 gcc library.o runme_too.o fun.o -o runme_too

library.o: library.c library.h
	gcc -c library.c -o library.o

runme.o: runme.c
	gcc -c runme.c -o runme.o

fun.o: fun.c fun.h
	gcc -c fun.c -o fun.o

clean:
	rm -f runme_too
	rm -f runme
	rm -f *.o
