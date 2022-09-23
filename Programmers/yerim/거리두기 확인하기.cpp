// [81302] 2021 카카오 채용연계형 인턴십 거리두기 확인하기
#include <string>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

bool visited[5][5];
int dx1[4] = {-1, 0, 1, 0}, dy1[4] = {0, 1, 0, -1}; // 상하좌우
int dx2[4] = {-1, -1, 1, 1}, dy2[4] = {-1, 1, 1, -1}; // 대각선
queue<pair<int, int>> q;

bool checkRoom(vector<string> room, int sx, int sy)
{
    q.push({sx, sy});
    visited[sx][sy] = true;

    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for(int i = 0; i < 4; i++) { // 상하좌우
            int nx = x + dx1[i];
            int ny = y + dy1[i];
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if(room[nx][ny] == 'P') return false;
        }

        for(int i = 0; i < 4; i++) { // 상하좌우 2칸
            int nx = x + dx1[i] * 2;
            int ny = y + dy1[i] * 2;
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if(visited[nx][ny]) continue;
            if(room[nx][ny] == 'P') {
                if(room[x + dx1[i]][y + dy1[i]] != 'X') return false; 
                q.push({nx, ny});
                visited[nx][ny] = true;
            }
        }

        for(int i = 0; i < 4; i++) { // 대각선
            int nx = x + dx2[i];
            int ny = y + dy2[i];
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if(visited[nx][ny]) continue;
            if(room[nx][ny] == 'P') { // 대각선에 다른 지원자 -> 파티션 체크
                if(i == 0 && (room[x - 1][y] != 'X' || room[x][y - 1] != 'X')) return false;
                else if(i == 1 && (room[x - 1][y] != 'X' || room[x][y + 1] !=' X')) return false;
                else if(i == 2 && (room[x + 1][y] != 'X' || room[x][y + 1] != 'X')) return false;
                else if(i == 3 && (room[x + 1][y] != 'X' || room[x][y - 1] != 'X')) return false;
                q.push({nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
    return true;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    for(int i = 0; i < places.size(); i++) {
        bool flag = true;
        while(!q.empty()) q.pop(); 
        memset(visited, false, sizeof(visited));

        for(int j = 0; j < 5; j++) {
            for(int k = 0; k < 5; k++) {
                if(places[i][j][k] == 'P' && visited[j][k] == false) {
                    if(checkRoom(places[i], j, k) == false) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag == false) break;
        }
        if(flag == false) answer.push_back(0);
        else answer.push_back(1);
    }
    return answer;
}