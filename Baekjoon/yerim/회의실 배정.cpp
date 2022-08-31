// [1931] 회의실 배정
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<pair<int, int> > meeting;

void input()
{
    int start, end;
    cin >> n;
    for(int i = 0 ; i < n ; i++) {
        cin >> start >> end;
        meeting.push_back(make_pair(end, start));
    }
}

int maxNum()
{
    int cnt = 0, endTime = 0;
    sort(meeting.begin(), meeting.end());
    for(int i = 0 ; i < n ; i++) {
        if(meeting[i].second >= endTime) { // 다음 회의의 시작 시간 >= 현재 회의의 종료 시간
            cnt++;
            endTime = meeting[i].first;
        }
    }
    return cnt;
}

int main(void)
{
    cin.tie(NULL); 
    ios_base::sync_with_stdio(false);
    
    input();
    cout << maxNum() << '\n';
    
    return 0;
}