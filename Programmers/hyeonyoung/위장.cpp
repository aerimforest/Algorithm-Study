#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes)
{
    map<string, int> kind;
    for (vector<string> cloth : clothes)
    {
        kind[cloth[1]]++;
    }

    int answer = 1;
    for (pair<string, int> k : kind)
    {
        answer *= k.second + 1;
    }

    return --answer;
}
