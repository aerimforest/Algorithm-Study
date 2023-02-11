#include <iostream>
#include <map>

using namespace std;
int N , F; 
int T;
string tt; // DDD/hh:mm

//map of maps
map<string, map <string, int> > mom;
map<string, long long > fines;

int mtomin(int m){
  int min = 0;
  //int days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  int days_cum[12] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

  min = days_cum[m - 1] * 60 * 24 ;

  return min;
}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> N;
  cin >> tt;
  cin >> F;

  //cout << ">" << tt.substr(0, 3)  << " " << tt.substr(4, 2) << " " <<  tt. substr(7, 2) << "\n";

  T = stoi(tt.substr(0, 3)) * 60 * 24 + stoi(tt.substr(4,2)) * 60 + stoi(tt.substr(7,2));
  
  for(int i = 0 ; i < N; i++){
    //yyyy-MM-dd hh:mm
    string s;
    int t, m, d, h, min;
    string p; // product
    string n; // name
    
    cin >> s;
  
    m = stoi(s.substr(5,2));
    d = stoi(s.substr(8,2));

    //cout << " m, d : " << m << " " << d << "\n";
    
    cin >> s;

    h = stoi(s.substr(0,2));
    min = stoi(s.substr(3,2));

    //cout << "h, min : " << h << " " << min << "\n";
    
    cin >> p >> n;

    t = mtomin(m) + d * 60 * 24 + h * 60 + min;

    auto item = mom.find(n);


    if(item == mom.end()){
      map<string, int> tmp;
      tmp.insert(make_pair(p, t));
      mom.insert(make_pair(n, tmp));
    }else {
      map<string, int> m1 = item->second;
      auto t1 = m1.find(p);
      if(t1 == m1.end()){

        m1.insert(make_pair(p, t));
        item->second = m1;
      } else {
        // calc fine
        if(t - m1[p] > T){ 
          long long fineM = F * (t- m1[p] - T);
          auto fine = fines.find(n);
          if(fine == fines.end()){
            fines.insert( make_pair(n, fineM ));
          }else {
            fines[n] += fineM;
          }
          //cout <<"fines : "<< fines[n] << "\n";
        }
        m1.erase(p);
        item->second = m1;
      }
    }
  }

  if(fines.size() == 0 ){
    cout << -1;
  } else {
    for (auto const & [k, v] : fines){
      cout << k << " " << v << "\n";
    }
  }

  
  return 0;
}
