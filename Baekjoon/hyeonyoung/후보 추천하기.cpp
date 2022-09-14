// 220909_BOJ_1713

#include <iostream>
#include <list>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;
int candidates[101];
list<pair<int, int *>> photo;
vector<int> ans;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; ++i)
    {
        int x;
        cin >> x;

        if (candidates[x] > 0)
        {
            candidates[x]++;
        }
        else if (photo.size() < N)
        {
            candidates[x]++;
            photo.push_back({x, &candidates[x]});
        }
        else
        {
            auto idx = photo.begin();
            for (auto i = photo.begin(); i != photo.end(); i++)
            {
                if (*i->second < *idx->second)
                {
                    idx = i;
                }
            }
            *idx->second = 0;
            photo.erase(idx);

            candidates[x]++;
            photo.push_back({x, &candidates[x]});
        }
    }

    for (auto n : photo)
    {
        ans.push_back(n.first);
    }
    sort(ans.begin(), ans.end());

    for (auto n : ans)
    {
        cout << n << " ";
    }

    return 0;
}
