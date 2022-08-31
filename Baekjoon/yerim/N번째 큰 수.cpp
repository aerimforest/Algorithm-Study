// [2075] N번째 큰 수
#include <iostream>
#include <queue>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, num, cnt = 1;
    priority_queue<int, vector<int>, greater<int>> pq;

    cin >> n;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> num;
            pq.push(num);
            if(pq.size() > n) {
                pq.pop();
            }
        }
    }
    cout << pq.top() << '\n';

    return 0;
}