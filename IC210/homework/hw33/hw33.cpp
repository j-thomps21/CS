#include <iostream>
#include <string>

using namespace std;

struct node
{
  string word;
  node* next;
};

void add2front(string word, node*& list);
void search(char, node* list);

int main()
{
  cout << "Enter words followed by END " << endl;
  node* list = new node;
  list = NULL;
  string newWord;
  for(cin >> newWord; newWord != "END"; cin >> newWord)
  {
    add2front(newWord, list);
  }

  char letter;
  cout << "What letter? ";
  cin >> letter;

  search(letter, list);
  return 0;
}


void add2front(string word, node*& list)
{
  node* temp = new node;
  temp->word = word;
  temp->next = list;
  list = temp;
}


void search(char letter, node* list)
{
  for(node* t = list; t!= NULL; t = t->next)
  {
    if(t->word[0] == letter) cout << t->word << endl;
  }
  return;
}
