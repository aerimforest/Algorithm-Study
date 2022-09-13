//12913

#include <iostream>
#include <vector>
using namespace std;

int check(vector<int>& v, int idx)
{
    int num = 0;

    for(int i = 0; i < 4; i++)
    {
        if(i != idx)
            num = max(num, v[i]);
    }
    return num;
}

int solution(vector<vector<int> > land)
{
    int answer = 0;

    for(int i = 1; i < land.size(); i++)
    {
        for(int j = 0; j < 4; j++)
        {
            land[i][j] += check(land[i-1], j);
            
            answer = max(answer, land[i][j]);
        }
    }
    return answer;
}