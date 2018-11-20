/*get_usna.c*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>


void * readServer(void * args)
{
  //read the response until EOF

  char response[4096];
  int* sock = (int*)args;
  int n = 0;
  while( (n = read(*sock, response, 4096)) > 0){
    //write response to stdout
    if(write(1, response, n) < 0){
      perror("write");
      exit(1);
    }
  }

  if(n< 0){
    perror("write");
  }
  return NULL;
}

void * writeServer(void * args)
{
  //send the request

  char request[4096];
  int* sock = (int*)args;
  int n = 0;
  while((n = read(0, request, 4096)) > 0){
    if(write(*sock,request,strlen(request)) < 0){
    perror("send");
    }
  }

  if (n<0){
    perror("read");
  }
  return NULL;
}

int main(int argc, char * argv[]){

  char* hostname = argv[1];    //the hostname we are looking up
  short port = atoi(argv[2]);                 //the port we are connecting on

  struct addrinfo *result;       //to store results
  struct addrinfo hints;         //to indicate information we want

  struct sockaddr_in *saddr_in;  //socket interent address

  int s,n;                       //for error checking

  int sock;                      //socket file descriptor

  char request[4096]; //the GET request

  char response[4096];           //read in 4096 byte chunks

  pthread_t wThread;
  pthread_t rThread;

  //setup our hints
  memset(&hints,0,sizeof(struct addrinfo));  //zero out hints
  hints.ai_family = AF_INET; //we only want IPv4 addresses

  //Convert the hostname to an address
  if( (s = getaddrinfo(hostname, NULL, &hints, &result)) != 0){
    fprintf(stderr, "getaddrinfo: %s\n",gai_strerror(s));
    exit(1);
  }

  //convert generic socket address to inet socket address
  saddr_in = (struct sockaddr_in *) result->ai_addr;

  //set the port in network byte order
  saddr_in->sin_port = htons(port);

  //open a socket
  if( (sock = socket(AF_INET, SOCK_STREAM, 0))  < 0){
    perror("socket");
    exit(1);
  }

  //connect to the server
  if(connect(sock, (struct sockaddr *) saddr_in, sizeof(*saddr_in)) < 0){
    perror("connect");
    exit(1);
  }

///
/// here
///
  pthread_create(&wThread, NULL, writeServer, (void *)&sock);
  pthread_create(&rThread, NULL, readServer,  (void *)&sock);


  pthread_join(wThread, NULL);
  pthread_join(rThread, NULL);
  //close the socket
  close(sock);

  return 0; //success
}
