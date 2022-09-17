// [2042] 구간 합 구하기
// 자료 구조, 세그먼트 트리
#include <iostream>
using namespace std;

int n, m, k, tmpN = 0;
long long tree[1024*1024*2];

void init()
{
    for(tmpN = 1; tmpN < n; tmpN *= 2); // tmpN = leafnode 개수
    for(int i = 0; i < tmpN * 2; i++) { // 트리 내 값 초기화
        tree[i] = 0;
    }
    for(int i = tmpN; i < tmpN + n; i++) { // leaf 채우기
        cin >> tree[i];
    }
    for (int i = tmpN - 1; i >= 1; i--) { // internal 채우기 
        tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
}

void update(int a, long long b)
{
    a = a + tmpN - 1;
    tree[a] = b;
    while(a > 0) {
        a = a >> 1;
        tree[a] = tree[a * 2] + tree[a * 2 + 1];
    }
}

long long getSum(int a, int b)
{
    long long sum = 0;
    a = a + tmpN - 1;
    b = b + tmpN - 1;
    while(a <= b) {
        // a가 right child라면(짝수라면)
        if((a & 1) == 1) sum += tree[a];
        // b가 left child라면(홀수라면)
        if((b & 1) == 0) sum += tree[b];
        a = (a + 1) >> 1; // 오른쪽 친구의 부모로 올라감
        b = (b - 1) >> 1; // 자기 부모로 올라감
    }
    return sum;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    long long a, b, c;
    cin >> n >> m >> k;
    init();
    for(int i = 0; i < m + k; i++) {
        cin >> a >> b >> c;
        if(a == 1) update(b, c);
        else cout << getSum(b, c) << '\n';
    }
    return 0;
}