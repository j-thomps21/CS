#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

string** hands(string*);
string* createDeck();
void randCard(string*);
void printPlayerCards(string**, char, int);
void HitorStand(string**, string*, int&, int&, int&);
void addTohands(string**, string*, int&, int&, int&, bool, char);
string printDealerCards(string**, char, char, int, int);
void PlayerDealerPoints(string**, int, int);
void outputfirstlines(string**);
void lineschecker(string**, string*, string* deck, int&, int&, int&, bool);
void randomCouts(string**, int, int, int, bool);
void testprint(string** hands, string* deck, int dhc, int phc, int dealCounter);
string** blankHands (string**);

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

  //creates two arrays, one with the dealer's hand and other with the
  //player's hand
  string** gameHands = hands(deck);

  //initializes the hands with blanks
  gameHands = blankHands(gameHands);

  //initializes the hands and makes counter for cards dealt from the deck
  //also initializes counter for how many cards are in each hand
  int dealCounter = 4;
  //dhc = Dealer Hand Counter
  //phc = Player Hand Counter
  int phc = 2;
  int dhc = 2;
  for(int i = 0; i < 4; i++)
  {
    gameHands[i%2][i/2] = deck[i];
  }

  //the bulk of the program runs through this funciton
  HitorStand(gameHands, deck, dealCounter, dhc, phc);
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
  int j = 0;
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



void randCard(string* deck)
{
  //we do the random operation 52 times for each card in the deck
  for(int i = 0; i < 52; i++)
  {
    //create a temporary string for the swap
    string tempstring;

    //generate a random number from 1-52
    int j = rand() % 52;

    //Once we have the random number we use the value of that index
    //and make that the value of the tempstring. Then replace that
    //value with the actual one in the deck.
    tempstring = deck[i];

    deck[i] = deck[j];
    deck[j] = tempstring;
  }
}


string** hands(string* deck)
{
  //Creates a 2D array, with the first pointer pointing to the player's hand
  //and the second pointer pointing to the dealer's hand
  string** game = new string*[2];

  //each hand has up to 26 cards in it though it will likely not use that many
  for(int j = 0; j < 2; j++)
  {
    game[j] = new string[26];
  }

  return game;
}

string** blankHands(string** hands)
{
  for(int i = 0; i < 26; i++)
  {
    hands[1][i] = "   ";
    hands[0][i] = "   ";
  }
  return hands;
}


//this function is the main game part of the program
void HitorStand(string** hands, string* deck, int& dealCounter, int& dhc, int& phc)
{
  //creates the answer variables and their repective histories. These are for
  //when a player decides to stand one round then hit later on
  char panswer, danswer, phist, dhist;
  panswer = 'h';
  danswer = 'h';
  phist = 'h';
  dhist = 'h';

  //lines array is all the lines created from the responses from the players
  string* lines = new string[50];
  for(int i = 1; i < 4; i++)
  {
    //we output the first two cards for each player
    outputfirstlines(hands);

    //outputs the other lines after the first round is complete
    if(i > 1)
    {
    for(int k = 2; k < i+1; k++)
      {
        if(lines[k] == lines[k-1])
          continue;
        if(hands[0][2] == "   " && hands[1][2] == "   ")
          continue;
        cout << lines[k] << endl;
      }
    }

    //couts the round and who's turn it is then prompts the user for a hit or stand
    //the lineschecker function is for the instance when the player has previously stood
    //but now decides to hit. The history variables are useful for this situation
    //the addTohands function is for all other situations
    randomCouts(hands, dhc, phc, i, false);
    phist = panswer;
    cin >> panswer;
    if (phist == 's' && panswer == 'h') lineschecker(hands, lines, deck, dhc, phc, dealCounter, false);
    else addTohands(hands, deck, dealCounter, dhc, phc, false, panswer);
    cout << endl << endl;


    //pretty much a repeat of what happened above
    outputfirstlines(hands);
    if(i > 1)
    {
    for(int k = 2; k < i+1; k++)
      {
        if(lines[k] == lines[k-1])
          continue;
        if(hands[0][2] == "   " && hands[1][2] == "   ")
          continue;
        cout << lines[k] << endl;
      }
    }
    if (!(phist == 's' && panswer == 'h')) printPlayerCards(hands, panswer, phc-1);

    randomCouts(hands, dhc, phc, i, true);
    dhist = danswer;
    cin >> danswer;
    if (dhist == 's' && danswer == 'h') lineschecker(hands, lines, deck, dhc, phc, dealCounter, true);
    else addTohands(hands, deck, dealCounter, dhc, phc, true, danswer);
    cout << endl << endl;
    if(phc < dhc && i == 3) hands[0][phc] = "   ";
    if (!(dhist == 's' && danswer == 'h')) lines[i+1] = printDealerCards(hands, panswer, danswer, dhc-1, phc-1);
  }

    //prints out everything at the end
    outputfirstlines(hands);
    for(int i = 2; i < 5; i++)
    {
      if(lines[i] == lines[i-1])
        continue;
      if(hands[0][2] == "   " && hands[1][2] == "   ")
          continue;
      cout << lines[i] << endl;
    }
}

//this funciton adds the cards to the respective player's hands
void addTohands(string** hands, string* deck, int& dealCounter, int& dhc, int& phc, bool player, char answer)
 {
   //if the player decides to hit, then the player hand counter is
   //used as the index for the hand and the dealCounter is used as the index
   //for which card to take from the deck. The card from the deck is added to the hand.
   //then we add onto the counters
   if (answer == 'h')
   {
     if(player == false)
     {
       hands[0][phc] = deck[dealCounter];
       phc++;
       dealCounter++;
     }
     else if(player == true)
     {
       hands[1][dhc] = deck[dealCounter];
       dhc++;
       dealCounter++;
     }
   }
   //if the player decides to stand then instead of adding a card, spaces are put
   //into the hand
   else
   {
     if(player == false)
     {
       hands[0][phc] = "   ";
       phc++;
     }
     else if(player == true)
     {
       hands[1][dhc] = "   ";
       dhc++;
     }
   }
   return;
 }

void printPlayerCards(string** game, char answer, int phc)
{
  //if the player stands, then nothing happens
  if (answer == 's')
  {
    return;
  }
  //if the player hits, then it prints out their card
  else if (answer == 'h')
  {
    if(game[0][phc][0] == '1')
      cout << "|" << game[0][phc] << "  |      |" << endl;
    else
      cout << "| " << game[0][phc] << "  |      |" << endl;
  }
}

//this funtion returns a string to the lines array which is later used to print out the
//player's hands
string printDealerCards(string** game, char panswer, char danswer, int dhc, int phc)
{
  string line;
  if(game[0][phc][0] == '1')
    line = "|" + game[0][phc] + "  |";
  else
    line = "| " + game[0][phc] + "  |";

  if(game[1][dhc][0] == '1')
    line += game[1][dhc] + "  |";
  else
    line += " " + game[1][dhc] + "  |";
  return line;
}


 void outputfirstlines(string** hands)
 {
    cout << " Player Dealer" << endl;
    hands[0][0][0] == '1' ? cout << "|" << hands[0][0] : cout << "| " << hands[0][0];
    hands[1][0][0] == '1' ? cout << "  |" << hands[1][0] << "  |" << endl : cout << "  | " << hands[1][0] << "  |" << endl;
    hands[0][1][0] == '1' ? cout << "|" << hands[0][1] : cout << "| " << hands[0][1];
    hands[1][1][0] == '1' ? cout << "  |" << hands[1][1] << "  |" << endl : cout << "  | " << hands[1][1] << "  |" << endl;
 }

//in the special case where a player previously stood, then decided to hit, we call the lineschecker function.
 void lineschecker(string** hands, string* lines, string* deck, int& dhc, int& phc, int& dealCounter, bool player)
 {
   //the player variable checks whether it is the player or the dealer
   //Using a loop, we check each value of the player's hand and the first empty one found
   //is replaced by real card values
   if(player == false)
   {
     //I do not use a for loop for this becuase the i value is needed for outside of the loop
     int i = 0;
     while(i < phc)
     {
       char check = hands[0][i][1];
       if(check == ' ')
       {
         hands[0][i] = deck[dealCounter];
         dealCounter++;
         break;
       }
       i++;
     }
      if(hands[0][i][0] == '1')
        lines[i] = "|" + hands[0][i] + "  |";
      else
        lines[i] = "| " + hands[0][i] + "  |";

      if(hands[1][i][0] == '1')
        lines[i] += hands[1][i] + "  |";
      else
        lines[i] += " " + hands[1][i] + "  |";
   }
   else if(player == true)
   {
     int i = 0;
     while(i < dhc)
     {
       char check = hands[1][i][1];
       if(check == ' ')
       {
         hands[1][i] = deck[dealCounter];
         dealCounter++;
         break;
       }
       i++;
     }
      if(hands[0][i][0] == '1')
        lines[i] = "|" + hands[0][i] + "  |";
      else
        lines[i] = "| " + hands[0][i] + "  |";

      if(hands[1][i][0] == '1')
        lines[i] += hands[1][i] + "  |";
      else
        lines[i] += " " + hands[1][i] + "  |";
   }
 }


 void randomCouts(string** hands, int dhc, int phc, int i, bool player)
 {
   if(player == false)
   {
     cout << "Round " << i << " Player's turn" << endl;
     cout << "hit or stand? [h/s] ";
   }
   else
   {
     cout << "Round " << i << " Dealer's turn" << endl;
     cout << "hit or stand? [h/s] ";
   }
 }
