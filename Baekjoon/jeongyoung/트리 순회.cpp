#include <iostream>

#define pii pair <int, int >
using namespace std;

int N;
// (1 -> 2, 3) 2-> 4,5...
pii tree[30];

void preorder(int node){
  if(node == -1)
    return;
  char ret = 'A' + node;
  cout << ret;
  preorder(tree[node].first);
  preorder(tree[node].second);
}

void inorder(int node){
  if(node == -1)
    return;
  char ret = 'A' + node;
  inorder(tree[node].first);
  cout << ret;
  inorder(tree[node].second);
}

void postorder(int node){
  if(node == -1)
    return;
  char ret = 'A' + node;
  postorder(tree[node].first);
  postorder(tree[node].second);
  cout << ret;
}
int main() {

  cin >> N;

  for(int i = 0 ; i < N; i++){
    char a, b, c;
    cin >> a >> b >> c;

    tree[a-'A'].first = -1;
    tree[a-'A'].second = -1;

    if(b != '.')
      tree[a - 'A'].first = b-'A';
    if(c != '.')
      tree[a - 'A'].second = c-'A';
  }

  preorder(0);
  cout <<"\n";
  inorder(0);
  cout <<"\n";
  postorder(0);



  return 0;
}
