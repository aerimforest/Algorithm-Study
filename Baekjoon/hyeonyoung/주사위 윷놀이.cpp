// 220911_BOJ_17825

#include <iostream>

using namespace std;

// 점수, 이동 후 위치
const int init[33][6] = {{0, 1, 2, 3, 4, 5},
                         {2, 2, 3, 4, 5, 6},
                         {4, 3, 4, 5, 6, 7},
                         {6, 4, 5, 6, 7, 8},
                         {8, 5, 6, 7, 8, 9},
                         {10, 23, 24, 25, 28, 29},
                         {12, 7, 8, 9, 10, 11},
                         {14, 8, 9, 10, 11, 12},
                         {16, 9, 10, 11, 12, 13},
                         {18, 10, 11, 12, 13, 14},
                         {20, 26, 27, 28, 29, 30},
                         {22, 12, 13, 14, 15, 16},
                         {24, 13, 14, 15, 16, 17},
                         {26, 14, 15, 16, 17, 18},
                         {28, 15, 16, 17, 18, 19},
                         {30, 20, 21, 22, 28, 29},
                         {32, 17, 18, 19, 31, 32},
                         {34, 18, 19, 31, 32, 32},
                         {36, 19, 31, 32, 32, 32},
                         {38, 31, 32, 32, 32, 32},
                         {28, 21, 22, 28, 29, 30},
                         {27, 22, 28, 29, 30, 31},
                         {26, 28, 29, 30, 31, 32},
                         {13, 24, 25, 28, 29, 30},
                         {16, 25, 28, 29, 30, 31},
                         {19, 28, 29, 30, 31, 32},
                         {22, 27, 28, 29, 30, 31},
                         {24, 28, 29, 30, 31, 32},
                         {25, 29, 30, 31, 32, 32},
                         {30, 30, 31, 32, 32, 32},
                         {35, 31, 32, 32, 32, 32},
                         {40, 32, 32, 32, 32, 32},
                         {0, 32, 32, 32, 32, 32}};

int board[33], dice[10], horse[4], ans = 0;

void solve(int idx, int s)
{
    // if (ans < s)
    // {
    //     cout << idx << "\t" << s << "\t";
    //     for (int i = 0; i < 4; ++i)
    //     {
    //         cout << horse[i] << " ";
    //     }
    //     cout << "\n";
    // }

    ans = max(ans, s);
    if (idx == 10)
    {
        return;
    }

    for (int i = 0; i < 4; ++i)
    {
        int cur = horse[i], next = init[cur][dice[idx]];
        if (cur == 32)
        {
            continue;
        }
        if (next == 32)
        {
            board[cur] = 0;
            horse[i] = next;
            solve(idx + 1, s);
            board[cur] = 1;
            horse[i] = cur;
        }
        else if (board[next] == 0)
        {
            board[cur] = 0;
            board[next] = 1;
            horse[i] = next;
            solve(idx + 1, s + init[next][0]);
            board[next] = 0;
            board[cur] = 1;
            horse[i] = cur;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 10; ++i)
    {
        cin >> dice[i];
        dice[i];
    }

    solve(0, 0);

    cout << ans << "\n";

    return 0;
}
