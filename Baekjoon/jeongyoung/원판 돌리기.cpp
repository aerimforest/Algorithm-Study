#include <iostream>
#include <vector>

#define X 2e9
#define pii pair< int, int >
using namespace std;

int dy[2] = {0, 1};
int dx[2] = {1, 0};
int N, M, T;

int circles[55][55];
int s_index[55]; // start of circle -> 0 ~< M
int total = 0;
int totalNum = 0;

void turn(int x, int d, int k){

  for(int i = x; i <= N; i += x){
    int orig = s_index[i-1];
    if(d == 1){
      s_index[i-1] = (s_index[i-1] + k) % M;
    } else {
      s_index[i-1] = (s_index[i-1] + (50 * M) - k) % M;
    }
  }
}

void elim(){

  vector<pii> nums;
  for(int i = 0 ; i < N; i++){
    for(int j = 0; j < M; j++){
      int newj = (j + s_index[i] + 50 * M) % M ;
      int num = circles[i][newj];

      if(num == X)
        continue;

      for(int k = 0; k < 2; k++){
        int ni = i + dy[k];
        int nj = (j + s_index[ni] + dx[k] + 50 * M) % M;


        if(ni < 0 || ni >=  N)
          continue;
      
        if(circles[ni][nj] == X)
          continue;
        

        if(num == circles[ni][nj]){
          //cout << ">" << i << " " << newj << " " << num << " >>" << ni << " "  << nj << "  " << circles[ni][nj] <<  "\n";
          nums.push_back(make_pair(i, newj));
          nums.push_back(make_pair(ni, nj));
        }
      }
    }
  }


  for(int i = 0 ; i < nums.size(); i++){
    int ci = nums[i].first ;
    int cj = nums[i].second ;
    if(circles[ci][cj] != X){

      //cout << ci << " " << cj << " "<< circles[ci][cj] <<"\n";
      total -= circles[ci][cj];
      circles[ci][cj] = X;
      totalNum--;
    }
  }

  double avg;
  if(nums.size() == 0){
    avg = (double)total / totalNum;
    //cout << "no match, avg : " << avg <<"\n";

    for(int i = 0; i < N ; i++){
      for(int j = 0; j < M ; j++){
        if(circles[i][j] == X)
          continue;
        else if(circles[i][j] > avg ){
          circles[i][j]--;
          total--;
        }
        else if(circles[i][j] < avg){
          circles[i][j]++;
          total++;
        }
      }
    }
  }
}

void printC(){
  for(int i = 0; i < N ; i++){
    cout << s_index[i] << " : ";
    for(int j = 0 ; j < M ; j++){
      int newj = (j + s_index[i]) % M;
      if(circles[i][newj] == X)
        cout << "X" << " ";
      else
        cout << circles[i][newj] << " ";
    }
    cout << "\n";
  }
}

int main()
{
  cin >> N >> M >> T;

  for(int i = 0; i < N; i++){
    for(int j = 0 ; j < M; j++){
      cin >> circles[i][j];
      total += circles[i][j];
      totalNum++;
    }
  }

  for(int i = 0 ; i < T ; i++){
    //cout << "----" << i+1 << "----\n";
    int x, d, k;
    cin >> x >> d >> k;
    turn(x, d, k);
    elim();
    //printC();
  }


  cout << total ;


  return 0;
}
