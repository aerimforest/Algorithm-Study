// 221016_BOJ_5052

#include <iostream>
#include <cstring>

using namespace std;

int T, N;
char num[10001][12];

struct Trie
{
    bool end;
    Trie *next[10];

    Trie()
    {
        end = false;
        for (int i = 0; i < 10; ++i)
        {
            next[i] = NULL;
        }
    }

    ~Trie()
    {
        for (int i = 0; i < 10; ++i)
        {
            if (next[i])
            {
                delete next[i];
            }
        }
    }

    void insert(char *str)
    {
        if (*str == NULL)
        {
            end = true;
            return;
        }

        int cur = *str - '0';
        if (next[cur] == NULL)
        {
            next[cur] = new Trie();
        }
        next[cur]->insert(str + 1);
    }

    bool check(char *str)
    {
        if (*str == NULL)
        {
            return true;
        }
        if (end)
        {
            return false;
        }

        int cur = *str - '0';
        return next[cur]->check(str + 1);
    }
};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        memset(num, 0, sizeof(num));
        Trie *head = new Trie();

        cin >> N;
        for (int i = 0; i < N; ++i)
        {
            cin >> num[i];
            head->insert(num[i]);
        }

        bool ans = true;
        for (int i = 0; i < N; ++i)
        {
            if (!(head->check(num[i])))
            {
                ans = false;
                break;
            }
        }

        if (ans)
        {
            cout << "YES\n";
        }
        else
        {
            cout << "NO\n";
        }
    }

    return 0;
}
