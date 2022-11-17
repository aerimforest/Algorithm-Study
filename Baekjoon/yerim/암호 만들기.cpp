// [1759] 암호 만들기
// 수학, 브루트포스, 조합론, 백트래킹
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int l, c;
char arr[16];
bool visited[26];
vector <char> num;

// cnt = 현재까지 선택한 알파벳의 개수
void dfs(int cnt, int vowel, int consonant)
{
    // m개를 모두 선택 & 모음 1개 이상 & 자음 2개 이상
    if(cnt == l && vowel >= 1 && consonant >= 2) {
        for(int i = 0 ; i < l ; i++) {
            cout << arr[i];
        }
        cout << '\n';
        return;
    }

    for(int i = 0 ; i < c ; i++) {
        if(visited[num[i]-'a'] == false && arr[cnt - 1] < num[i]) { // 선택한 적이 없고 직전에 선택한 알파벳 보다 크다면
            visited[num[i]-'a'] = true; 
            arr[cnt] = num[i]; 
            if(num[i] == 'a' || num[i] == 'e' || num[i] == 'i' || num[i] == 'o' || num[i] == 'u') {
                dfs(cnt + 1, vowel + 1, consonant);
            }
            else {
                dfs(cnt + 1, vowel, consonant + 1);
            }
            visited[num[i]-'a'] = false;
        }
    }
}

int main(void)
{
    char tmp;
    cin >> l >> c;

    for(int i = 0 ; i < c ; i++) {
        cin >> tmp;
        num.push_back(tmp);
    }

    sort(num.begin(), num.end());
    dfs(0, 0, 0);

    return 0;
}