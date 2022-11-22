// [1205] 등수 구하기
#include <iostream>
#include <vector>
using namespace std;

int N, P, score;
vector<int> vec;

void input()
{   
    cin >> N >> score >> P;
    for(int i = 0; i < N; i++) {
		int x;
		cin >>x;
		vec.push_back(x);
	}
}

void solve()
{
    int rank = 1;

    if(N == P && vec[N - 1] >= score) rank = -1;
	else {
		for(int i = 0; i < N; i++) { 
			if(vec[i] > score) {
                rank++;
            }
		}
	}
	cout << rank << '\n';
}

int main(void) 
{
	ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
	
    input();
    solve();
	
	return 0;
}