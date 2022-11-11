// 221111_BOJ_7682

#include <iostream>
#include <string>

using namespace std;

string input;
char board[3][3];

bool ttt(char c)
{
    // 가로
    for (int i = 0; i < 3; ++i)
    {
        bool ret = true;
        for (int j = 0; j < 3 && ret; ++j)
        {
            ret = (ret && (board[i][j] == c));
        }
        if (ret)
        {
            return true;
        }
    }
    // 세로
    for (int j = 0; j < 3; ++j)
    {
        bool ret = true;
        for (int i = 0; i < 3 && ret; ++i)
        {
            ret = (ret && (board[i][j] == c));
        }
        if (ret)
        {
            return true;
        }
    }
    // 대각선
    bool ret = true;
    for (int i = 0; i < 3; ++i)
    {
        ret = (ret && (board[i][i] == c));
    }
    if (ret)
    {
        return true;
    }
    ret = true;
    for (int i = 0; i < 3; ++i)
    {
        ret = (ret && (board[i][2 - i] == c));
    }
    if (ret)
    {
        return true;
    }

    return false;
}

bool solve()
{
    int Xcnt = 0, Ocnt = 0;
    for (int i = 0; i < 3; ++i)
    {
        for (int j = 0; j < 3; ++j)
        {
            if (board[i][j] == 'X')
            {
                Xcnt++;
            }
            else if (board[i][j] == 'O')
            {
                Ocnt++;
            }
        }
    }

    // 순서 X
    if (Xcnt != Ocnt && Xcnt != Ocnt + 1)
    {
        return false;
    }

    // 다 차있을 때 == X가 마지막
    if (Xcnt + Ocnt == 9)
    {
        if (ttt('O'))
        {
            return false;
        }
        return true;
    }

    // X가 마지막
    if ((Xcnt + Ocnt) & 1)
    {
        if (!ttt('O') && ttt('X'))
        {
            return true;
        }
        return false;
    }
    // O가 마지막
    else
    {
        if (ttt('O') && !ttt('X'))
        {
            return true;
        }
        return false;
    }
    return false;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (1)
    {
        cin >> input;
        if (input == "end")
        {
            break;
        }

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                board[i][j] = input[i * 3 + j];
            }
        }

        if (solve())
        {
            cout << "valid\n";
        }
        else
        {
            cout << "invalid\n";
        }
    }

    return 0;
}
