//1927

#include<iostream>
#include<queue>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
    int n;
    priority_queue<int, vector<int>, greater<int>> pq;
    cin >> n;

    for(int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;

        if(tmp == 0)
        {
            if(pq.empty())
                cout << 0 << '\n';
            
            else
            {
                cout << pq.top() << '\n';
                pq.pop();
            }
        }
        else
            pq.push(tmp);
    }

    return 0;
}