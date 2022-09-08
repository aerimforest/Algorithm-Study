// [20055] 컨베이어 벨트 위의 로봇
#include <iostream>
#include <deque>
using namespace std;

int n, k, zeroPower;
struct Info {
    bool isRobot;
    int power;
};
deque<Info> belt;

void input()
{
    int power;
    cin >> n >> k;
    for(int i = 0; i < 2*n; i++) {
        cin >> power;
        belt.push_back({false, power});
    }
}

void rotate()
{
    Info info = belt.back();
    belt.pop_back();
    belt.push_front(info);
    if(belt[n-1].isRobot) belt[n-1].isRobot = false;
}

void moveRobot()
{
    for(int i = n-2; i >= 0; i--) {
        if(belt[i].isRobot == true && belt[i+1].isRobot == false && belt[i+1].power >= 1) {
            belt[i+1].isRobot = true;
            belt[i+1].power--;
            if(belt[i+1].power == 0) zeroPower++;
            if(i+1 == n-1) belt[i+1].isRobot = false; 
            belt[i].isRobot = false;
        }
    }
}

void addRobot()
{
    if(belt[0].power > 0) {
        belt[0].isRobot = true;
        belt[0].power--;
        if(belt[0].power == 0) zeroPower++;
    }
}

int solve()
{
    int level = 0;
    while(true) {
        level++;
        rotate();
        moveRobot();
        addRobot();
        if(zeroPower >= k) break;
    }
    return level;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    cout << solve() << '\n';

    return 0;
}