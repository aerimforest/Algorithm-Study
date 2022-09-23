// [60059] 2020 KAKAO BLIND RECRUITMENT 자물쇠와 열쇠
#include <string>
#include <vector>
using namespace std;
 
int N, M, mapSize;
 
void rotateKey(vector<vector<int>> &key) {
    vector<vector<int>> tmpKey(key.size(), vector<int>(key.size()));
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            tmpKey[j][N - 1 - i] = key[i][j];
        }
    }
    key = tmpKey;
}
 
bool fillKey(int x, int y, vector<vector<int>> key, vector<vector<int>> map) {
    for (int i = x; i < x + N; i++) {
        for (int j = y; j < y + N; j++) {
            map[i][j] += key[i - x][j - y];
        }
    }
    for (int i = N - 1; i <= mapSize - N; i++) {
        for (int j = N - 1; j <= mapSize - N; j++) {
            if (map[i][j] == 1) continue;
            return false;
        }
    }
    return true;
}
 
bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    bool answer = false;
    N = key.size();
    M = lock.size();
    mapSize = M + (N - 1) * 2;

    vector<vector<int>> map(mapSize, vector<int>(mapSize));
    for (int i = N - 1; i <= mapSize - N; i++) {
        for (int j = N - 1; j <= mapSize - N; j++) {
            map[i][j] = lock[i - N + 1][j - N + 1];
        }
    }

    for (int r = 0; r < 4; r++) {
        for (int i = 0; i <= mapSize - N; i++) {
            for (int j = 0; j <= mapSize - N; j++) {
                if (fillKey(i, j, key, map)) {
                    answer = true;
                    return answer;
                }
            }
        }
        rotateKey(key);
    }
 
    return answer;
}