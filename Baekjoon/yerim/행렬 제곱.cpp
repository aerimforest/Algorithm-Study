// [10830] 행렬 제곱
#include <iostream>
using namespace std;

long long n, b;
int arr[5][5], result[5][5], tmp[5][5];

void squareMatrix(int a1[5][5], int a2[5][5]) 
{	
	for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
			tmp[i][j] = 0;
			for (int k = 0; k < n; k++) {
                tmp[i][j] += (a1[i][k] * a2[k][j]);
            }
			tmp[i][j] %= 1000;
		}
    }
	for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            a1[i][j] = tmp[i][j];	
        }
    }
}

void input()
{
    cin >> n >> b;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
		result[i][i] = 1;
	}
}

void solve()
{
    while (b) {
		if (b % 2 == 1) {
			squareMatrix(result, arr);
		}
		squareMatrix(arr, arr);
		b /= 2;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
            cout << result[i][j] << ' ';
        }
		cout << endl;
	}
}

int main() 
{
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);

    input();
    solve();

	return 0;
}