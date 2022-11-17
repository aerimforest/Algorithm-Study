// 221116_BOJ_8983

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int M, N, L;
int shooting[100002];
pair<int, int> animal[100002];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> M >> N >> L;
    for (int i = 0; i < M; ++i)
    {
        cin >> shooting[i];
    }
    sort(shooting, shooting + M);
    for (int i = 0; i < N; ++i)
    {
        cin >> animal[i].first >> animal[i].second;
    }
    sort(animal, animal + N);

    int answer = 0;
    // 동물마다 잡힐 수 있는 위치인지 확인
    for (int i = 0; i < N; ++i)
    {
        int x = animal[i].first, y = animal[i].second;

        // 가장 가까운 사대 찾기
        int l = 0, r = M - 1;
        while (l <= r)
        {
            int m = (l + r) / 2;
            if (abs(x - shooting[m]) + y <= L)
            {
                answer++;
                break;
            }
            else if (x < shooting[m])
            {
                r = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }
    }
    cout << answer;

    return 0;
}
