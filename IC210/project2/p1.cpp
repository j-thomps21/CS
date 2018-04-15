#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

string* createDeck();
void printcard(int, string*);
void randCard(string*);

int main()
{
  //Prompt the user
  cout << "Shuffle: [n | u <seed>]: ";
  char ans;
  cin >> ans;
  if (ans == 'u')
  {
  //If the user wants a shuffled deck then take in the seed
  int n;
  cin >> n;
  srand(n);
  }

  //Creates a deck that is in order
  string* deck = createDeck();

  //If the user wanted a shuffled deck then shuffle the deck
  if(ans == 'u')
  {
    randCard(deck);
  }

  //Prints out the deck
    for(int i = 1; i <= 52; i++)
    {
      cout << deck[i] << endl;
    }

  return 0;
}


string* createDeck()
{
  //Send the codes for the suit shapes to string variables
  string clubs = "\u2663";
  string spades = "\u2660";
  string diamonds = "\u2666";
  string hearts = "\u2665";


  //Create and array for the suits
  string *shape;
  shape = new string[4];
  shape[0] = clubs;
  shape[1] = diamonds;
  shape[2] = hearts;
  shape[3] = spades;


  //Create and array for the card values
  string *faceval;
  faceval = new string[14];
  for(int i = 0; i < 9; i++)
   faceval[i] = i+'1';
   faceval[9] = "10";
   faceval[10] = 'J';
   faceval[11] = 'Q';
   faceval[12] = 'K';
   faceval[13] = 'A';


   //Now we create a new array for the entire deck
   string* cards = new string[53];

  //Now we create the entire deck combining the suits with the card values
  int j = 1;
  for(int i = 0; i < 4; i++)
    {
      for(int ii = 0; ii < 14; ii++)
      {
        if(ii == 0)
        continue;

        if(ii != 9)
        {
          cards[j] = " " + faceval[ii] + shape[i];
        }
        else
        cards[j] = faceval[ii] + shape[i];
        j++;
      }
    }
  return cards;
}



//Will probably delete this later on
void printcard(int x, string* deck)
{
  cout << deck[x];
}





void randCard(string* deck)
{
  //Create a temporary deck
  string* tempdeck = new string[52];
    for(int i = 0; i < 52; i++)
    {
      tempdeck[i] = deck[i+1];
    }

  //we do the random operation 52 times for each card in the deck
  for(int i = 1; i <= 52; i++)
  {
    //create a temporary string for the swap
    string tempstring;

    //generate a random number from 1-52
    int j = 1 + rand() % 52;

    //Once we have the random number we use the value of that index
    //and make that the value of the tempstring. Then replace that
    //value with the actual one in the deck.
    tempstring = deck[i];
  //  cout << "BEFORE SWAP DECK[i]    " << deck[i] << "    DECK[j]    " << deck[j] << endl;

    deck[i] = deck[j];
    deck[j] = tempstring;
    //cout << "AFTER SWAP DECK[i]:     " << deck[i] << "    DECK]j]:     " << deck[j] << endl;
  }

}
