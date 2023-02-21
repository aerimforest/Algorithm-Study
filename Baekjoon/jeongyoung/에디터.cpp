#include <iostream>
#include <list>

using namespace std;

string str;
list<char> l;
// linked list
int main(){

  cin >> str;
  for(int i = 0; i < str.size() ; i++){
    l.push_back(str[i]);
  }

  int N;
  cin >> N;
  auto it = l.end();
  for(int i = 0 ; i < N ; i++){
    char c;
    cin >> c;
    if( c == 'L' ){
      if(it != l.begin()) it--;
    }else if( c == 'D'){
      if(it != l.end()) it++;
    } else if( c == 'B'){
      if(it != l.begin()){
        it = l.erase(--it);
      }
    } else {
      char s;
      cin >> s;
      l.insert(it, s);
    }
  }
  for(auto it2 = l.begin(); it2 != l.end(); it2++){
    cout << *it2;
  }

  return 0;
}
