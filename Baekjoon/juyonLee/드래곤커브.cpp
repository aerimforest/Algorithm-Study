#include <iostream>
#include <vector>
#define MAX 101

using namespace std;

typedef struct 
{
    int y, x;
}Dir;

Dir dir[4] = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

int main()
{
    int x, y, d, g, n;
    bool visited[MAX][MAX] = {false};

    cin >> n;

    for(int i = 0; i < n; i++)
    {
        cin >> x >> y >> d >> g;

        vector<int> c;

        c.push_back(d);

        for(int j = 0; j < g; j++)
        {
            vector<int> t = c;

            for(int k = t.size()-1; k >= 0; k--)
                c.push_back((t[k]+1) % 4);
        }

        visited[y][x] = true;

        for(int j = 0; j < c.size(); j++)
        {
            y += dir[c[j]].y;
            x += dir[c[j]].x;

            if(0 <= x && x < MAX && 0 <= y && y < MAX)
                visited[y][x] = true;
        }
    }

    int ans = 0;

    for(int j = 0; j < 100; j++)
    {
        for(int k = 0; k < 100; k++)
            if(visited[j][k] && visited[j][k+1] && visited[j+1][k] && visited[j+1][k+1])
                ans+=1;
    }

    cout << ans << '\n';

    
}