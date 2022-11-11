// [7682] 틱택토
#include <iostream>
using namespace std;

int cnt[2]; // X 개수, O 개수
string s;

bool isWinner(char c)
{
    if(s[0] == c && s[1] == c && s[2] == c) return true;
    if(s[3] == c && s[4] == c && s[5] == c) return true;
    if(s[6] == c && s[7] == c && s[8] == c) return true;
    if(s[0] == c && s[3] == c && s[6] == c) return true;
    if(s[1] == c && s[4] == c && s[7] == c) return true;
    if(s[2] == c && s[5] == c && s[8] == c) return true;
    if(s[0] == c && s[4] == c && s[8] == c) return true;
    if(s[2] == c && s[4] == c && s[6] == c) return true;
    
    return false;
}

void getCnt()
{
    for(int i = 0; i < 2; i++) cnt[i] = 0; // init
    for(char c: s) {
        if(c == 'X') cnt[0]++;
        else if(c == 'O') cnt[1]++;
    }
}

bool solve()
{
    bool isXWin = isWinner('X');
    bool isOWin = isWinner('O');
    getCnt();
    
    if(isXWin && !isOWin && cnt[0] == cnt[1] + 1) return true;
    if(isOWin && !isXWin && cnt[0] == cnt[1]) return true;
    if(!isXWin && !isOWin && cnt[0] == 5 && cnt[1] == 4) return true;
    
    return false;
}

void input()
{
    while(true) {
        cin >> s;
        if(s == "end") break;
        else {
            if(solve()) cout << "valid\n";
            else cout << "invalid\n";
        }
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();

    return 0;
}