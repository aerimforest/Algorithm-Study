#include <iostream>
#include <algorithm>
#include <vector>

#define pii pair < int, int >
#define ppiipii pair < pii, pii > // orientations, left-top coord
#define pic pair < int, char >

using namespace std;
// simulation? brute force
// nPr = 10P3 = 720,
// 720 * 4 orientations * 4 possible positions * 4*4 calculations
// O(184320)
int N;
pic tmp[4][4]; // stores result of transpose, rotate90 and revColumns
pic ingred[4][15][4][4]; // 0 : original, 1: 90, 2: 180 3: 270 degree rotated counter clockwise 
vector < ppiipii > chosen; // coord, mat
bool used[15];

void transpose(){
  for(int i = 0 ; i < 4 ; i++){
    for(int j = i ; j < 4 ; j++){
      swap(tmp[i][j], tmp[j][i]);
    }
  }
}

void revColumns(){
  for(int i = 0 ; i < 4 ; i++){
    for(int j = 0, k = 3 ; j < k ; j++, k--){
      swap(tmp[j][i], tmp[k][i]);
    }
  }
}

void printTmp(){
  cout << "\n-------------------\n";
  for(int i = 0 ; i < 4; i++){
    for(int j = 0 ; j < 4; j++){
      cout << "["<< tmp[i][j].first << ", " << tmp[i][j].second << "] ";
    }
    cout << "\n";
  }
}

void rotate90(){
  transpose();
  revColumns();
}

void deepCopy(pic (&src)[4][4], pic (&dest)[4][4]){
  for(int i = 0 ; i < 4; i++){
    for(int j = 0 ; j < 4; j++){
      dest[i][j] = src[i][j];
    }
  }
}

int calc(){
  pic x = make_pair(0, 'W');
  pic res[5][5] = {
    {x,x,x,x,x},
    {x,x,x,x,x},
    {x,x,x,x,x},
    {x,x,x,x,x},
    {x,x,x,x,x},
  };

  for(int i = 0 ; i < 3; i++){
    int ori = chosen[i].first.first;
    int idx = chosen[i].first.second;
    int u = chosen[i].second.first;
    int w = chosen[i].second.second;

    for(int j = 0 ; j < 4; j++){
      for(int k = 0; k < 4; k++){
        int val = res[u+j][w+k].first;
        int color = res[u+j][w+k].second;

        int nval = ingred[ori][idx][j][k].first;
        int ncolor = ingred[ori][idx][j][k].second;

        if(val + nval > 9){
          res[u+j][w+k].first = 9;
        } else if (val + nval < 0){
          res[u+j][w+k].first = 0;
        } else {
          res[u+j][w+k].first = val + nval;
        }
        if(ncolor != 'W')
          res[u+j][w+k].second = ncolor;
      }
    }
  }

  int ans = 0;
  for(int j = 0 ; j < 5; j++){
    for(int k = 0; k < 5; k++){
      int val = res[j][k].first;
      char color = res[j][k].second;
      if(color == 'R')
        ans += val * 7;
      if(color == 'B')
        ans += val * 5;
      if(color == 'G')
        ans += val * 3;
      if(color == 'Y')
        ans += val * 2;
    }
  }

  return ans;
}

int solve(int idx){
  int ans = 0;

  if(chosen.size() == 3)
    return calc();

  if(idx >= N)
    return 0;

  // not chosen
  //ans = max(ans, solve(idx+1));
  
  // chosen
  
  for(int u = 0 ; u < N ; u++){
    if(used[u])
      continue;
    used[u] = true;
    for(int i = 0; i < 4 ; i++){
      for(int j = 0; j < 2; j++){
        for(int k = 0; k < 2; k++){
          chosen.push_back(make_pair(make_pair(i, u), make_pair(j, k)));
          ans = max(ans, solve(idx+1));
          //cout << ans << " <=   " << i << " " << idx << "\n";
          chosen.pop_back();
        }
      }
    }
    used[u] = false;
  }

  return ans;
}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> N;

  for(int i = 0 ; i < N ; i++){
    pic mat[4][4];

    for(int j = 0 ; j < 4; j++){
      for(int k = 0 ; k < 4 ; k++){
        cin >> mat[j][k].first;
      }
    }

    for(int j = 0 ; j < 4; j++){
      for(int k = 0 ; k < 4 ; k++){
        cin >> mat[j][k].second;
      }
    }

    deepCopy(mat, tmp);
    deepCopy(tmp, ingred[0][i]);
    
    for(int j = 1 ; j <= 3 ; j++){
      rotate90();
      deepCopy(tmp, ingred[j][i]);
    }
  }

  cout << solve(0);

  return 0;
}
