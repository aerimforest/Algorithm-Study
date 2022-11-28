// [2470] 두 용액
#include <cstdio>
#include <algorithm>
using namespace std;

int priorityArr[100001];

void solution(int n)
{
    int s = 0, e = n-1, ans_s = 0, ans_e = n-1, ans = 2000000000;
    sort(priorityArr, priorityArr + n);

    while(s < e) {
        int sum = priorityArr[s] + priorityArr[e];
        if(abs(sum - 0) < abs(ans)) {
            ans = sum;
            ans_s = s; ans_e = e;
        }
        if(sum > 0) {
            e--;
        }
        else if(sum < 0) {
            s++;
        }
        else {
            ans_s = s; ans_e = e;
            break;
        }
    }
    printf("%d %d\n", priorityArr[ans_s], priorityArr[ans_e]);
}

int main(void)
{
    int n, priority;
    scanf("%d", &n);
    for(int i = 0; i < n; i++) {
        scanf("%d", &priorityArr[i]);
    }
    solution(n);
    return 0;
}