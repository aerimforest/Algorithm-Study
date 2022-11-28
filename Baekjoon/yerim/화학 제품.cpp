// [8901] 화학 제품
#include <cstdio>
#include <algorithm>
using namespace std;

void solve()
{
    int t;
    scanf("%d", &t);

    while (t--) {
        int a, b, c, p, q, r, result = 0, cost[3];
        scanf("%d %d %d", &a, &b, &c);
        scanf("%d %d %d", &cost[0], &cost[1], &cost[2]);

        p = min(a, b);
        q = min(b, c);
        
        for (int i = 0; i <= p; i++) {   
            int tmp = 0;
            for (int j = 0; j <= q; j++) {
                if (b < i + j) continue;
                r = min(a - i, c - j);
                tmp = cost[0] * i + cost[1] * j + cost[2] * r;
                result = max(result, tmp);
            }
        }
        printf("%d\n", result);
    }
}

int main() 
{
    solve();

    return 0;
}