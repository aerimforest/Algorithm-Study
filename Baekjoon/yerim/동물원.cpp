// [1309] 동물원
// dp[i] = 2(가로) * i(세로) 크기의 동물원에 사자를 배치하는 방법의 수
#include <cstdio>

int main(void)
{
    int n, dp[100001];
    scanf("%d", &n);
    dp[0] = 1; dp[1] = 3;
    
    for(int i = 2 ; i <= n ; i++) {
        dp[i] = (dp[i - 1]*2 + dp[i - 2]) % 9901;
    }

    printf("%d\n", dp[n]);
    return 0;
}