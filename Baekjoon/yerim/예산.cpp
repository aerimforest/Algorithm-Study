// [2512] 예산
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, totalBudget;
vector<int> budget;

void input()
{
    int num;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> num;
        budget.push_back(num);
    }
    cin >> totalBudget;
}

void solve()
{
    int meanBudget;
    sort(budget.begin(), budget.end());
    meanBudget = budget[n - 1];
 
    while(true) {
        int sum = 0;
        for(int num: budget) {
            sum += num > meanBudget ? meanBudget : num;
        }
        if(sum <= totalBudget) break;
        else meanBudget--;
    }

    cout << meanBudget << '\n';
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}