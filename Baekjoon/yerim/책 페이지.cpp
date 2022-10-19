// [1019] 책 페이지
// 해설 참고
#include <iostream>
using namespace std;
const int MAX = 10;

long long numbers[MAX];

void calculate(int num, int increase)
{
	while (num) {
		numbers[num % 10] += increase;
		num /= 10;
	}
}

void func(int start, int end, int digit)
{
	while (start % 10 && start <= end) {
		calculate(start, digit);
		start++;
	}

	if (start > end) {
		return;
	}

	while (end % 10 != 9 && start <= end) {
		calculate(end, digit);
		end--;
	}

	long long cnt = (end / 10 - start / 10 + 1);
	for (int i = 0; i < MAX; i++) {
		numbers[i] += cnt * digit;
	}

	func(start / 10, end / 10, digit * 10);
}

void output()
{
    for (int i = 0; i < MAX; i++) {
		cout << numbers[i] << " ";
	}
	cout << "\n";
}

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	int N;
	cin >> N;
	
	func(1, N, 1);
    output();

	return 0;
}