// [1927] 최소 힙
#include <iostream>
#include <queue>
using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, num;
    priority_queue<int, vector<int>, greater<int>> pq;

    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> num;
        if(num > 0) pq.push(num);
        else {
            if(!pq.empty()) {
                cout << pq.top() << '\n';
                pq.pop();
            }
            else cout << "0\n";
        }
    }

    return 0;
}