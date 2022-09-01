//2075

#include <iostream>
#include <queue>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, tmp;
    priority_queue<int, vector<int>, greater<int>> pq;

    cin >> n;

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            cin >> tmp;
            pq.push(tmp);
        }

        while(pq.size() > n)
            pq.pop();
    }
    cout << pq.top();
    return 0;
}