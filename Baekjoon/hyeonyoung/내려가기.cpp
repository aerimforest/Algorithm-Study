// 221230_BOJ_2096

#include <iostream>

using namespace std;

int N, board[3];
int score[2][3][2];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < 3; ++i)
    {
        cin >> score[0][i][0];
        score[0][i][1] = score[0][i][0];
    }
    for (int i = 1; i < N; ++i)
    {
        for (int j = 0; j < 3; ++j)
        {
            cin >> board[j];
        }

        score[i & 1][0][0] = min(score[(i + 1) & 1][0][0], score[(i + 1) & 1][1][0]) + board[0];
        score[i & 1][1][0] = min(min(score[(i + 1) & 1][0][0], score[(i + 1) & 1][1][0]), score[(i + 1) & 1][2][0]) + board[1];
        score[i & 1][2][0] = min(score[(i + 1) & 1][1][0], score[(i + 1) & 1][2][0]) + board[2];

        score[i & 1][0][1] = max(score[(i + 1) & 1][0][1], score[(i + 1) & 1][1][1]) + board[0];
        score[i & 1][1][1] = max(max(score[(i + 1) & 1][0][1], score[(i + 1) & 1][1][1]), score[(i + 1) & 1][2][1]) + board[1];
        score[i & 1][2][1] = max(score[(i + 1) & 1][1][1], score[(i + 1) & 1][2][1]) + board[2];

        // cout << score[i & 1][0][0] << " " << score[i & 1][1][0] << " " << score[i & 1][2][0] << "\t";
        // cout << score[i & 1][0][1] << " " << score[i & 1][1][1] << " " << score[i & 1][2][1] << "\n";
    }

    cout << max(max(score[(N - 1) & 1][0][1], score[(N - 1) & 1][1][1]), score[(N - 1) & 1][2][1]) << " ";
    cout << min(min(score[(N - 1) & 1][0][0], score[(N - 1) & 1][1][0]), score[(N - 1) & 1][2][0]) << " ";

    return 0;
}
