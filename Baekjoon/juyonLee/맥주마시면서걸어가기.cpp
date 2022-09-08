//9205

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
#define INF 987654321
#define MAX 1000
 
int main() {

    int t;
    cin >> t;

    while (t--) 
    {
        int n;
        cin >> n;

        vector<pair<int, int>> v1(n+2);
        vector<vector<long long>> v2(n + 2, vector<long long>(n + 2, 0));
        
        for (int i = 0; i < n + 2; i++)
        {
            int x, y;     
            cin >> x >> y;

            v1[i] = {x,y};
            v2[i][i] = 1;
        }
 
        for (int i = 0; i < n + 2; i++)
        {
            for (int j = i+1; j < n + 2; j++) 
            {
                int nx = abs(v1[i].first - v1[j].first);
                int ny = abs(v1[i].second - v1[j].second);
                long long dis = nx + ny;
 
                if (dis <= MAX)
                    v2[i][j] = v2[j][i] = 1;
            } 
        } 
 
        
        for (int k = 0; k < n + 2; k++)
            for (int i = 0; i < n + 2; i++)
                for (int j = 0; j < n + 2; j++)
                    if (v2[i][k] == 1 && v2[k][j] == 1)
                        v2[i][j] = 1;
 
        cout << (v2[0][n+1] ? "happy" : "sad") << '\n';
    }
    return 0; 
}
