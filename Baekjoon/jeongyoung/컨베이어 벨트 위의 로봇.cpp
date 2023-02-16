#include <iostream>
#include <vector>

using namespace std;
int N, K;

int arr[205];
int totalK = 0;
int rotate_idx = 0;

vector<int> robots; // robots on belt
bool isrobots[205];

void printRobot(){
  cout << rotate_idx << " : ";
  for(int i = 0 ; i < 2*N; i++){
    cout << arr[(i + rotate_idx) % (2*N)] << " ";
  }

  cout <<"\n";
  cout << "robots" << " : ";

  for(int i = 0 ; i < robots.size(); i++){
    cout << robots[i] << " ";
  }
  cout <<"\n";
}

void moveRobot(){
  bool putdown = false;
  for(int i = 0; i < robots.size(); i++){

    int next_idx = (robots[i] + 1) % (2*N);
    //cout << i << " > " <<  next_idx << "\n";
    if(arr[next_idx] > 0 && !isrobots[next_idx]){
      arr[next_idx]--;
      
      isrobots[robots[i]] = false;
      robots[i] = next_idx;
      isrobots[next_idx] = true;

      if(i == 0 && (rotate_idx + N -1 ) % (2*N) == next_idx){
        isrobots[next_idx] = false;
        putdown = true;
      }
    }
  }

  if(putdown){
    robots.erase(robots.begin());
  }
}

int main(){
  cin >> N >> K;

  for(int i = 0; i < 2*N ; i++){
    cin >> arr[i];
  }

  int step = 1;
  while(1){
    //moveBelt;
    rotate_idx = (rotate_idx - 1 + 2*N) % (2*N);
    
    if(robots.size() > 0 && (rotate_idx + N -1 ) % (2*N) == robots[0]){
      isrobots[robots[0]] = false;
      robots.erase(robots.begin());
    }

    moveRobot();
    
    // put robot
    if(arr[rotate_idx] > 0 ){
      robots.push_back(rotate_idx);
      arr[rotate_idx]--;
      isrobots[rotate_idx] = true;
    }

    totalK = 0;
    for(int i = 0 ; i < 2*N ; i++){
      if(arr[i] <= 0)
        totalK++;
    }
    
    //printRobot();
    
    if(totalK >= K)
      break;

    step++;
  }

  cout << step;
  return 0;
}
