// 221029_BOJ_1092

#include <iostream>
#include <algorithm>

using namespace std;

int N, Crane[51], M, Box[10001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> Crane[i];
    }
    sort(Crane, Crane + N);
    cin >> M;
    for (int i = 0; i < M; ++i)
    {
        cin >> Box[i];
    }
    sort(Box, Box + M);

    

    return 0;
}
