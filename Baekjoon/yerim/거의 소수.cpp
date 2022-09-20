// [1456] 거의 소수
#include <iostream>
#include <vector>
#define MAX 10000001
using namespace std;
typedef long long ll;

ll A, B, ans;
bool isPrime[MAX];
vector<int> primeVec;

void Eratos()
{
    for(int i = 2; i < MAX; i++) isPrime[i] = true; // 처음엔 전부 소수로 초기화
    for(int i = 2; i * i <= MAX; i++) {
		if(isPrime[i]) {
            for(int j = i * i; j < MAX; j += i) {
                isPrime[j] = false;
            }
        }
	}  
}

void getAlmostPrime()
{
    for(int i = 2; i <= MAX; i++) {
        if(isPrime[i]) {
            ll num = i, n = 2;
            while(num <= B / i) { // num * i <= b
                if(A <= num * i) ans++;
                num *= i;
            }
        }
    }
}

int main() 
{
    ios_base::sync_with_stdio(0); 
    cin.tie(0); cout.tie(0);

    cin >> A >> B;
    Eratos();
    getAlmostPrime();
    cout << ans << '\n';

    return 0;
}