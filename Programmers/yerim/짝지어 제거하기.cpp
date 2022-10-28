// [12973] 짝지어 제거하기
/* 
 string erase의 시간 복잡도: O(N) 
 -> 매번 지우는 방식으로 하면 100만*100만으로 시간초과 날 수 있음 
*/
#include <iostream>
#include <string>
#include <stack>
using namespace std;

int solution(string s)
{
    stack<char> st;
    for(char c: s) {
        if(!st.empty() && st.top() == c) {
            st.pop();
        }
        else {
            st.push(c);
        }
    }
    
    if(st.empty()) return 1;
    else return 0;
}