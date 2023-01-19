#include <iostream>
#include <string>
#include <vector>
#include <queue>

#define pii pair < int, int >
#define pipii pair < int, pii >

using namespace std;

// BBAAAAAAABB

bool visited[22][1 << 22];
int N;

int bfs(int cur, int rem){
    queue < pipii > q;

    visited[cur][rem] = true;
    q.push(make_pair(0, make_pair(cur, rem)));

    while(!q.empty()){
        int moves = q.front().first;
        int i = q.front().second.first;
        int nmap = q.front().second.second;
        q.pop();

        //cout << hex <<" hi " <<  nmap << " " << ~(1 << i) <<  "\n";

        nmap = nmap & ~(1 << i);

        // 11111110
        // 11000011
        cout << "cur : " <<  i  << " map: " << nmap <<  " " << moves << "\n";
        if(nmap == 0){
            return moves;
        }
        int li = i - 1 >= 0 ? i - 1 : N - 1;
        int ri = i + 1 < N ? i + 1 : 0;

        if(!visited[li][nmap]){
            visited[li][nmap] = true;
            q.push(make_pair(moves+1, make_pair(li, nmap)));
        }
        if(!visited[ri][nmap]){
            visited[ri][nmap] = true;
            q.push(make_pair(moves+1, make_pair(ri, nmap)));
        }   
    }
    return 0;
}

int solution(string name) {

    int map = 0;
    int answer = 0;
    N = name.size();

    for(int i = 0; i < name.size(); i++){

        if(name[i] != 'A') map |= (1 << i);
       // cout << hex << map << "\n";

        int updowns = min(name[i] - 'A', 'Z' + 1 - name[i]);    
        //cout << answer << " " << updowns <<  "\n";
        answer += updowns;
    }

    answer += bfs(0, map);

    return answer;
}
