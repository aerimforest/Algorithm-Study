#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    string s, t;

    cin >> s >> t;
    int ans = 0;

    while(s.length() != t.length())
    {
         char ch = t[t.length()-1];
            if( ch == 'A')
            {
                t.erase(t.length()-1, 1);
            }

            else if(ch == 'B')
            {
                t.erase(t.length()-1, 1);
                reverse(t.begin(), t.end());
            }
        }

    if(s == t)
        ans = 1;

    cout << ans << '\n';
    return 0;

}