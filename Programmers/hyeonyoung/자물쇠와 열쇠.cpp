#include <string>
#include <vector>
#include <cstring>

using namespace std;

vector<vector<int>> rotate(vector<vector<int>> arr)
{
    vector<vector<int>> ret(arr);
    int N = arr.size();
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            ret[i][j] = arr[j][N - 1 - i];
        }
    }

    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 0; j < N; ++j)
    //     {
    //         cout << arr[i][j] << " ";
    //     }
    //     cout << "\n";
    // }
    // for (int i = 0; i < N; ++i)
    // {
    //     for (int j = 0; j < N; ++j)
    //     {
    //         cout << ret[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    return ret;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock)
{
    int M = key.size(), N = lock.size();
    int L[61][61], cnt = 0;
    memset(L, 0, sizeof(L));
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (lock[i][j] == 0)
            {
                cnt++;
            }
            L[N + i][N + j] = lock[i][j];
        }
    }

    for (int k = 0; k < 4; ++k)
    {
        for (int i = N - M; i < N * 2; ++i)
        {
            for (int j = N - M; j < N * N; ++j)
            {
                bool unlock = true;
                int c = 0;
                for (int x = 0; x < M && unlock; ++x)
                {
                    for (int y = 0; y < M; ++y)
                    {
                        if (i + x >= N && i + x < 2 * N && j + y >= N && j + y < 2 * N)
                        {
                            if (key[x][y] == 1 && L[x + i][y + j] == 0)
                            {
                                c++;
                            }
                            if (key[x][y] == L[x + i][y + j])
                            {
                                unlock = false;
                                break;
                            }
                        }
                    }
                }
                if (cnt == c && unlock)
                {
                    return true;
                }
            }
        }

        key = rotate(key);
    }

    return false;
}
