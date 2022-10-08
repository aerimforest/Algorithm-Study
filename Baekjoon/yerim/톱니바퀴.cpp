// [14891] 톱니바퀴
#include <iostream>
#include <vector>
using namespace std;

int k;
vector <string> state, tmp;

void rotateOneWheel(int idx, int dir) 
{
    if(dir == 1) {
        int num = tmp[idx][7];
        tmp[idx].pop_back();
        tmp[idx].insert(tmp[idx].begin(), num);
    }
    else {
        int num = tmp[idx][0];
        tmp[idx].erase(tmp[idx].begin());
        tmp[idx].push_back(num);
    }
}

bool leftSide(int compare, int idx, int dir)
{
    if(state[compare-1][6] != state[idx-1][2]) {
        rotateOneWheel(idx-1, dir);
        return true;
    }
    return false;
}

bool rightSide(int compare, int idx, int dir)
{
    if(state[compare-1][2] != state[idx-1][6]) {
        rotateOneWheel(idx-1, dir);
        return true;
    }
    return false;
}

void go(int num, int dir)
{
    switch (num) {
        case 1:
            if(rightSide(1, 2, -1*dir)) {
                if(rightSide(2, 3, dir)) {
                    rightSide(3, 4, -1*dir);
                }
            }
            break;
        case 2:
            leftSide(2, 1, -1*dir);
            if(rightSide(2, 3, -1*dir)) {
                rightSide(3, 4, dir);
            }
            break;
        case 3:
            if(leftSide(3, 2, -1*dir)) {
                leftSide(2, 1, dir);
            }
            rightSide(3, 4, -1*dir);
            break;
        case 4:
            if(leftSide(4, 3, -1*dir)) {
                if(leftSide(3, 2, dir)) {
                    leftSide(2, 1, -1*dir);
                }
            }
        default: break;
    }
    rotateOneWheel(num-1, dir);
}

void input()
{
    int num, dir;
    string s;
    for(int i = 0; i < 4; i++) {
        cin >> s;
        state.push_back(s);
        tmp.push_back(s);
    }
    cin >> k;
    for(int i = 0; i < k; i++) {
        cin >> num >> dir;
        go(num, dir);
        copy(tmp.begin(), tmp.end(), state.begin());
    }
}

int getScore()
{
    int ans = 0;
    if(state[0][0] == '1') ans += 1;
    if(state[1][0] == '1') ans += 2;
    if(state[2][0] == '1') ans += 4;
    if(state[3][0] == '1') ans += 8;

    return ans;
}

int main(void)
{
    input();
    cout << getScore() << '\n';

    return 0;
}