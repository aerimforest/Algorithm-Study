#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <queue>

using namespace std;

struct song
{
    int play, num;

    bool operator<(const song &X) const
    {
        if (this->play == X.play)
        {
            return this->num > X.num;
        }
        return this->play < X.play;
    }
};

vector<int> solution(vector<string> genres, vector<int> plays)
{
    int n = genres.size();
    map<string, int> count;
    map<string, priority_queue<song>> songs;
    for (int i = 0; i < n; ++i)
    {
        count[genres[i]] += plays[i];
        songs[genres[i]].push({plays[i], i});
    }
    vector<pair<int, string>> G;
    for (pair<string, int> p : count)
    {
        G.push_back({p.second, p.first});
    }
    sort(G.begin(), G.end());
    int g = G.size();

    vector<int> answer;
    for (int i = g - 1; i >= 0; --i)
    {
        priority_queue<song> *S = &songs[G[i].second];

        if (!S->empty())
        {
            answer.push_back(S->top().num);
            S->pop();
        }
        if (!S->empty())
        {
            answer.push_back(S->top().num);
            S->pop();
        }
    }

    return answer;
}
