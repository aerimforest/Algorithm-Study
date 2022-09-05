//9935

#include <iostream>
#include <string>
#include <vector>

using namespace std;

string str1, boomstr;
vector<char> v;
bool check = false;

int main()
{
    cin >> str1 >> boomstr;

    for(int i = 0; i < str1.size(); i++)
    {
        v.push_back(str1[i]);

        if(v.size() >= boomstr.size())
        {
            check = true;

            for(int i = 0; i < boomstr.size(); i++)
            {
                if(v[v.size() - boomstr.size() + i] != boomstr[i])
                {
                    check = false;
                    break;
                }
            }

            if(check)
            {
                for(int i = 0; i < boomstr.size(); i++)
                    v.pop_back();
            }
        }
    }


    if(v.empty())
        cout << "FRULA" << '\n';

    else
    {
        for(int i = 0; i < v.size(); i++)
            cout << v[i];
    }

}