//42587
#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    priority_queue<int> pq;
    queue<pair<int, int > > q;

    int pqSize = priorities.size();

    for(int i = 0; i < pqSize; i++)
    {
        q.push(make_pair(i, priorities[i]));
        pq.push(priorities[i]);
    }

    while(!q.empty())
    {
        int idx = q.front().first;
        int tier = q.front().second;

        q.pop();

        if(tier == pq.top())
        {
            pq.pop();
            answer += 1;

            if(idx == location)
                break;
        }
         else   
                q.push(make_pair(idx, tier));
        
        
    }


    return answer;
}


//내가 인쇄를 요청한 문서 순서
//중요도가 높을수록 먼저 인쇄됨.
//우선순위가 같을 경우 해당 문서에서 오른쪽 방향 순서대로 진행됨.

//priority queue 이용. (우선순위 중요, 해당 순위인 데이터 pop되어야 해서, 최대 힙 정렬)
//priority queue값(가장 우선순위 높은 값) == 현재 문서 우선순위 일 경우 인쇄, location과 같으면 break, 다르면 다시 큐에 넣고 진행.