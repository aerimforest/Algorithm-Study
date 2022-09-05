//19583
#include<iostream>
#include <string>
#include <set>

using namespace std;

string s, e, q, str, name;
int ans = 0;
set<string> set1;

long long strToNum(string s)
{
    string time = s.substr(0, 2);
    string min = s.substr(3, 2);

    return 60 * stoi(time) + stoi(min);
}

int main()
{
    cin >> s >> e >> q;
    
    long long changedS = strToNum(s);
    long long changedE = strToNum(e);
    long long changedQ = strToNum(q);

    while(cin.eof() == false)
    {
        cin >> str;
        string time = str.substr(0, 2);
        string min = str.substr(3, 2);

        long long timeNum = stoi(time);
        long long minNum = stoi(min);

        cin >> name;

        if(timeNum > 23 || timeNum < 0 || minNum > 59)
            break;

        
        long long finalTime = strToNum(str);

        if(finalTime <= changedS)
            set1.insert(name);

            else if(changedE <= finalTime && finalTime <= changedQ)
            {
                if(set1.find(name) != set1.end())
                {
                    ans+=1;

                    auto it = set1.find(name);
                    set1.erase(it);
                }
            }
    }

    cout << ans << '\n';
}