#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string name) {
    int answer = 0;
    for(char c : name){
        int dif = c - 'A';
        answer += min(dif, 26-dif);
    }
    int len = name.size();
    int count = len, a = 0, b = len, cnt = 0;
    for(int i = 0; i < len; i++){
        if(name[i] != 'A'){
            a = max(a, i);
            if(i > 0) {
                b = min(b, i);          
            }
            if(i-cnt-1 > 0){
                count = min(count, min(i-cnt-1, len-i) + len-cnt-1);
            }
            cnt = 0;
        }
        else{
            cnt++;
        }

    }
    count = min(count, a);
    count = min(count, len-b);
    
    answer += count;

    return answer;
}
