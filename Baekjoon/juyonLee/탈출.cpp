//3055
#include <iostream>
#include <string>
#include <queue>
using namespace std;

const int MAX = 50;
typedef struct{
        int x,y;
}dir; 

dir movedir[4] = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

int R, C;
pair<int, int> start, destination;
string graph[MAX];
queue<pair<int, int>> river;
int cache[MAX][MAX];

int BFS(void){
        queue<pair<int, int>> mole;
        mole.push(start);
        cache[start.first][start.second] = 1;

        while (!mole.empty()){
                 int curRiverSize = river.size();
                 for (int j = 0; j < curRiverSize; j++){
                         int curY = river.front().first;
                         int curX = river.front().second;
                         river.pop();
                         for (int k = 0; k < 4; k++){
                                 int nextY = curY + movedir[k].y;
                                 int nextX = curX + movedir[k].x;
                                 if (0 <= nextY && nextY < R && 0 <= nextX && nextX < C){
                                          if (graph[nextY][nextX]=='.'){
                                                  graph[nextY][nextX] = '*';
                                                  river.push(make_pair(nextY, nextX));
                                          }
                                 }
                         }
                 }

                 int curSize = mole.size();
                 for (int i = 0; i < curSize; i++){
                         int y = mole.front().first;
                         int x = mole.front().second;
                         mole.pop();
                         if (y == destination.first && x == destination.second)
                                 return cache[y][x] - 1;

                         for (int j = 0; j < 4; j++){
                                 int nextY = y + movedir[j].y;
                                 int nextX = x + movedir[j].x;

                                 if (0 <= nextY && nextY < R && 0 <= nextX && nextX < C)
                                          if (graph[nextY][nextX] != '*' && graph[nextY][nextX] != 'X' && cache[nextY][nextX] == 0){
                                                  cache[nextY][nextX] = cache[y][x] + 1;
                                                  mole.push(make_pair(nextY, nextX));
                                          }
                         }
                 }
        }
        return -1;
}
 

int main(void){
        int result;
        cin>>R >>C;
        for (int i = 0; i < R; i++){
                 cin >> graph[i];
                 for (int j = 0; j < C; j++)
                         if (graph[i][j] == 'S')
                                 start = make_pair(i, j);
                         else if (graph[i][j] == '*')
                                 river.push(make_pair(i, j));
                         else if (graph[i][j] == 'D')
                                 destination = make_pair(i, j);
        }
        result = BFS();
        if (result == -1)
                 cout << "KAKTUS" << endl;
        else
                 cout << result << endl;
        return 0;
}