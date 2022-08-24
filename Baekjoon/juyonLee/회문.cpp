#include <iostream>
#include <string>

using namespace std;

int t;
string str;

int pal(int left, int right, bool ispal)
{
    while(left <= right)
    {
        if(str[left] == str[right])
        {
            left += 1;
            right -= 1;
            continue;
        }

        if(!ispal)
            return 2;
        
        int ans = 2;

        if(str[left + 1] == str[right])
        {
            ans = pal(left + 1, right, 0);

            if(ans != 2) return 1;
        }

        if(str[left] == str[right - 1])
        {
            ans = pal(left, right - 1, 0);
            
            if(ans != 2) return 1;
        }
        return ans;
    }
    return 0;

}

int main()
{
    cin >> t;
    
    while(t--)
    {
        cin >> str;
        cout << pal(0, str.length()-1, 1) << '\n';
    }
}

/*
abbab 1
aab 1
aaab 1
aaaab  1
aaaaab 1
aaaaaab 1
axaaxaa 1
abcddadca 2 /1
aabcbcaa 1
ababbabaa 1
abca 1 /0
babba 1
sumumuus 1
XYXYAAYXY 1
abc 2
cccfccfcc 1
abcddcdba 1
ppbpppb 2 /1
aabcdeddcba 2 /1
aabab 2 /1
aapqbcbqpqaa 1 /2
*/


