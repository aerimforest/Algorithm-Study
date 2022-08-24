//1062
#include <iostream>
using namespace std;
int n, k, word;
int arr[51];

int backtracking(int depth, int idx)
{
    int ret = 0;
    if(depth == k - 5)
    {
        for(int i = 0; i < n; i++)
        {
            if((arr[i] & word) == arr[i]) 
                ret++;
        }
        return ret;
    }

    for(int i = idx; i < 26; i++)
    {
        if(word & (1<<i)) 
            continue;

        word |= (1 << i);
        ret = max(ret,backtracking(depth + 1, i + 1));
        word &= ~(1 << i);
    }
    return ret;
}

int main()
{
    cin >> n >> k;
    string str;
    for(int i = 0; i < n; i++) {
        cin >> str;
        for(int j = 0; j < str.size(); j++) 
            arr[i] |= 1 << (str[j] - 'a');
    }
    if(k < 5) {cout << 0; return 0;}
    word |= 1 << ('a' - 'a');
    word |= 1 << ('c' - 'a');
    word |= 1 << ('i' - 'a');
    word |= 1 << ('t' - 'a');
    word |= 1 << ('n' - 'a');

    cout << backtracking(0,0);

}