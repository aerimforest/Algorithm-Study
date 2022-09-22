#include <string>
#include <vector>

using namespace std;

struct applicant
{
    int input;
    int score;
};

vector<int> solution(vector<string> info, vector<string> query)
{
    vector<applicant> applicants;
    for (string i : info)
    {
        int input = 0;

        int prev = 0, cur = 0;
        // 개발언어
        cur = i.find(' ');
        if (i[prev] == 'c')
        {
            input |= (1 << 0);
        }
        else if (i[prev] == 'j')
        {
            input |= (1 << 1);
        }
        else if (i[prev] == 'p')
        {
            input |= (1 << 2);
        }
        prev = cur + 1;
        // 직군
        cur = i.find(' ', prev);
        if (i[prev] == 'b')
        {
            input |= (1 << 3);
        }
        else if (i[prev] == 'f')
        {
            input |= (1 << 4);
        }
        prev = cur + 1;
        // 경력
        cur = i.find(' ', prev);
        if (i[prev] == 'j')
        {
            input |= (1 << 5);
        }
        else if (i[prev] == 's')
        {
            input |= (1 << 6);
        }
        prev = cur + 1;
        // 소울푸드
        cur = i.find(' ', prev);
        if (i[prev] == 'c')
        {
            input |= (1 << 7);
        }
        else if (i[prev] == 'p')
        {
            input |= (1 << 8);
        }
        prev = cur + 1;
        // 점수
        applicants.push_back({input, stoi(i.substr(prev))});
    }

    vector<int> answer;
    for (string q : query)
    {
        int x = 0;

        int prev = 0, cur = 0;
        // 개발 언어
        cur = q.find(' ');
        if (q[prev] == 'c')
        {
            x |= (1 << 0);
        }
        else if (q[prev] == 'j')
        {
            x |= (1 << 1);
        }
        else if (q[prev] == 'p')
        {
            x |= (1 << 2);
        }
        else
        {
            x |= (1 << 0);
            x |= (1 << 1);
            x |= (1 << 2);
        }
        prev = cur + 5;
        // 직군
        cur = q.find(' ', prev);
        if (q[prev] == 'b')
        {
            x |= (1 << 3);
        }
        else if (q[prev] == 'f')
        {
            x |= (1 << 4);
        }
        else
        {
            x |= (1 << 3);
            x |= (1 << 4);
        }
        prev = cur + 5;
        // 경력
        cur = q.find(' ', prev);
        if (q[prev] == 'j')
        {
            x |= (1 << 5);
        }
        else if (q[prev] == 's')
        {
            x |= (1 << 6);
        }
        else
        {
            x |= (1 << 5);
            x |= (1 << 6);
        }
        prev = cur + 5;
        // 소울푸드
        cur = q.find(' ', prev);
        if (q[prev] == 'c')
        {
            x |= (1 << 7);
        }
        else if (q[prev] == 'p')
        {
            x |= (1 << 8);
        }
        else
        {
            x |= (1 << 7);
            x |= (1 << 8);
        }
        prev = cur + 1;
        // 점수
        int s = stoi(q.substr(prev));

        int cnt = 0;
        for (applicant a : applicants)
        {
            if ((a.input & x) == a.input && a.score >= s)
            {
                cnt++;
            }
        }
        answer.push_back(cnt);
    }

    return answer;
}
