#include <iostream>
#include <vector>
#include <algorithm>
#define pii pair <int, int>

using namespace std;

int T;

// if there's value greater on right side, buy
// the sum of profit is the highest block - left blocks
// :=> 
// First thought :
// sort the array and if the number is the biggest, sell all.
// if not buy all (biggest - small)
// move index if biggest is met
//
// O(NlgN + N)
int main(){
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    
    cin >> T;

    while(T--){
        int N;
        vector <pii> sorted_nums;
        vector <int> nums;
        long long ans = 0;
        cin >> N;

        for(int i = 0; i < N; i++){
            int num;
            cin >> num;
            nums.push_back(num);          
            sorted_nums.push_back(make_pair(num, i));         
        }
        sort(sorted_nums.begin(), sorted_nums.end(), [](pii a, pii b){
                  if(a.first == b.first){
                    return a.second < b.second;
                  } else {
                    return a.first > b.first;
                  }
                }
            );

        for(int i = 0, j = 0 ; i < N ;){
          pii biggest = sorted_nums[j];
          if(nums[i] == biggest.first){
              i++;
              j++;
            }else if(i < biggest.second){
              ans += sorted_nums[j].first - nums[i];
              i++;
            } else {
              j++;
            }
        }
        cout << ans << "\n";
    }

    return 0;
}
