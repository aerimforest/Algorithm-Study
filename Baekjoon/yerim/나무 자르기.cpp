// [2805] 나무 자르기
#include <iostream>
using namespace std;

int n;
long long maxHeight, m, tree[1000001];

void input()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> tree[i];
        if(tree[i] > maxHeight) maxHeight = tree[i];
    }
}

long long cutTree(int height)
{
    long long cut = 0;
    for(int i = 0; i < n; i++) {
        if(tree[i] >= height) {
            cut += (tree[i] - height);
        }
    }
    return cut;
}

void solution()
{
    long long ans, left = 0 , mid, right = maxHeight;
    while(left <= right) {
        mid = (left + right) / 2;
        if(cutTree(mid) >= m) {
            ans = mid;
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    cout << ans << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    input();
    solution();
    return 0;
}