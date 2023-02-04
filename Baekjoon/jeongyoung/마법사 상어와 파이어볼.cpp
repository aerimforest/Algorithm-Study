#include <iostream>
#include <vector>

#define pii pair< int, int >
using namespace std;

struct fireball {
  int r;
  int c;
  int m;
  int s;
  int d;
};

struct tmp_fireball {
  tmp_fireball() : m(0), s(0), cnt(0){}
  int m ;
  int s ;
  int cnt ;
  vector<int> ds;
} ;

int dy[8] = {-1, -1, 0 , 1, 1, 1, 0, -1};
int dx[8] = {0, 1, 1, 1, 0, -1, -1, -1};
int N, M, K;

vector < fireball > fbs;
//vector < fireball > new_fbs;

int main(){

  cin >> N >> M >> K;

  for(int i = 0 ; i < M ; i++){
    int r, c, m, s, d;
    cin >> r >> c >> m >> s >> d;

    fireball fb;
    fb.r = r-1;
    fb.c = c-1;
    fb.m = m;
    fb.s = s;
    fb.d = d;
    fbs.push_back(fb);
  }

  while(K--){
    //cout << "------------------------------------------------------\n";
    int count[55][55];
    tmp_fireball map[55][55];
    
    for(int i = 0 ; i < fbs.size(); i++){
      
      int r = fbs[i].r;
      int c = fbs[i].c;
      int m = fbs[i].m;
      int s = fbs[i].s;
      int d = fbs[i].d;
      
      //cout << "> " << r << " " << c << " " << m << " " << s << " " << d <<  "\n";
      int ny = ((r + dy[d] * s) + N * 300) % N;
      int nx = ((c + dx[d] * s) + N * 300) % N;

      map[ny][nx].m += m;
      map[ny][nx].s += s;
      map[ny][nx].cnt++;
      map[ny][nx].ds.push_back(d);
    }
    fbs.clear();

    // calc & divide
    
    for(int i = 0; i < N; i++){
      for(int j = 0 ; j < N ; j++){
        if(map[i][j].cnt == 0)
          continue;

        if(map[i][j].cnt == 1){

          fireball fb;
          fb.r = i;
          fb.c = j;
          fb.m = map[i][j].m;
          fb.s = map[i][j].s;
          fb.d = map[i][j].ds[0];

          fbs.push_back(fb);
          continue;
        }

        if(map[i][j].m/5 == 0)
          continue;
        
        int id = 0;
        int orig = map[i][j].ds[0] % 2;
        for(int k = 1; k < map[i][j].cnt; k++){
          if(orig != map[i][j].ds[k] % 2){
            id = 1;
            break;
          }
        }
        
        for(int k = 0 ; k < 4; k++){
          fireball fb;
          fb.r = i;
          fb.c = j;
          fb.m = map[i][j].m/5;
          fb.s = map[i][j].s/map[i][j].cnt;
          fb.d = id;
          fbs.push_back(fb);

          id += 2;
        }
      }
    }
  }

  int ans = 0;
  for(int i = 0 ; i < fbs.size(); i++){
    ans += fbs[i].m;
  }

  cout << ans;
  return 0;
}
