#include <iostream>
#include <string>
#include <vector>
#include <queue>

#define pii pair < int, int >
#define piipi pair < pii, int >

using namespace std;

priority_queue<pii> pq; // cost time, index

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    
    for(int i = 0 ; i < jobs.size(); i++){
        pq.push(make_pair(-jobs[i][0], -jobs[i][1]));
    }
    
    int cur_time = 0;
    priority_queue<pii> ready_pq;
    
    while(!pq.empty() || !ready_pq.empty()){
        
        while(!pq.empty()){
            int in = -pq.top().first;
            int t = -pq.top().second;
                
            if(in > cur_time){
                if(ready_pq.empty()){
                    cur_time = in;
                    ready_pq.push(make_pair(-t, -in));
                    pq.pop();
                }
                break;
            }
                
            
            cout << "cur time : " << cur_time  << " " << in << " " <<  t  << "\n";
            ready_pq.push(make_pair(-t, -in));
            pq.pop();
            
        }
        int in = -ready_pq.top().second;
        int t = -ready_pq.top().first;
        ready_pq.pop();
        
        int tmp = 0;
        if(in < cur_time)
            tmp += cur_time - in;    
        tmp += t;
        cout << "cur time : " << cur_time  << " " << in << " " <<  t <<  " "  << tmp << "\n";

        answer += tmp;
        
        cur_time = cur_time + t;
    }
    cout << answer << "\n ";
    
    return answer/jobs.size();
}
