// 220908_BOJ_20055

#include <iostream>
#include <deque>

using namespace std;

int N, K, A[201];
int start = 0;
bool robot[201];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < 2 * N; ++i)
    {
        cin >> A[i];
    }

    int T, cnt = 0;
    for (T = 1;; ++T)
    {
        // 벨트 회전
        start = (start - 1 + (N << 1)) % (N << 1);
        if (robot[(start + N - 1) % (N << 1)])
        {
            robot[(start + N - 1) % (N << 1)] = false;
        }

        // 로봇 이동
        for (int i = 1; i < N; ++i)
        {
            int now = (start + N - (i + 1)) % (N << 1);
            int next = (now + 1) % (N << 1);

            if (robot[now] && A[next] > 0 && robot[next] == false)
            {
                A[next]--;
                robot[now] = false;
                robot[next] = true;
                if (A[next] == 0)
                {
                    cnt++;
                }
            }
        }
        if (robot[(start + N - 1) % (N << 1)])
        {
            robot[(start + N - 1) % (N << 1)] = false;
        }

        // 로봇 추가
        if (A[start] > 0)
        {
            A[start]--;
            robot[start] = true;
            if (A[start] == 0)
            {
                cnt++;
            }
        }

        // //
        // cout << "T" << T << "\n";
        // cout << "robot\t";
        // for (int i = 0; i < N; ++i)
        // {
        //     cout << robot[(start + i) % (N << 1)] << "\t";
        // }
        // cout << "\n";
        // cout << "A\t";
        // for (int i = 0; i < N; ++i)
        // {
        //     cout << A[(start + i) % (N << 1)] << "\t";
        // }
        // cout << "\n";

        // 종료?
        if (cnt >= K)
        {
            break;
        }
    }

    cout << T;

    return 0;
}
