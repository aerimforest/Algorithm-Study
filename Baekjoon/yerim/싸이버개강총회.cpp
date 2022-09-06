// [19583] 싸이버개강총회
#include <iostream>
#include <string>
#include <map>
using namespace std;

string SH, SM, EH, EM, QH, QM;
struct Info {
    bool in;
    bool out;
};
map<string, Info> checkMap;

void input()
{
    string s1, s2, s3;
    cin >> s1 >> s2 >> s3;
    cin.ignore();
    SH = s1.substr(0, 2); SM = s1.substr(3, 2);
    EH = s2.substr(0, 2); EM = s2.substr(3, 2);
    QH = s3.substr(0, 2); QM = s3.substr(3, 2);
    string H, M, nickname, time;
    while(!cin.eof()) {
        cin >> time >> nickname;
        H = time.substr(0, 2); M = time.substr(3, 2);
        if(checkMap.find(nickname) == checkMap.end()) {
            checkMap[nickname] = {false, false};
        }
        if(H < SH || (H == SH && M <= SM)) checkMap[nickname].in = true;
        else if(H > EH || (H == EH && M >= EM)) {
            if(H < QH || (H == QH && M <= QM)) {
                checkMap[nickname].out = true;
            }
        }
    }
}

int checkAttendance()
{
    int ans = 0;
    for(auto it = checkMap.begin(); it != checkMap.end(); it++) {
        if(it -> second.in && it -> second.out) {
            ans++;
        }
    }
    return ans;
}

int main(void)
{
    input();
    cout << checkAttendance() << '\n';

    return 0;
}