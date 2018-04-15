#include <iostream>

using namespace std;

struct node
{
  int data;
  node* next;
};


void add2front(int, node*&);

int main()
{
  node* list = new node;
  list->next = NULL;

  int val, count = 0;
  while(cin >> val)
  {
    add2front(val, list);
    count++;
    if(val < 0) break;
  }
  cout << list->next->next->next->data << endl;
  return 0;
}


void add2front(int val, node*& list)
{
  node* temp = new node;
  temp->data = val;
  temp->next = list;
  list = temp;
  return;
}
