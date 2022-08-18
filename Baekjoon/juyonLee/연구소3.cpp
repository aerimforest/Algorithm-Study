#include <iostream>
#include <utility>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;

int arr[50][50];
vector<pair<int, int> > nvirus;			
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,1,0,-1 };

int n, m, blank = 0;	
vector<int> ansV;
vector<int> vIdx;	
int visited[10] = {0};

void BFS() 
{
	int maxTime = 0, cnt = 0;
	int arr2[50][50];
	int arr3[50][50];

	memset(arr2, 0, sizeof(arr2));
	memset(arr3, 0, sizeof(arr3));

	queue<pair<int, int> > q;

	for (int i = 0; i < vIdx.size(); i++) 
    {	
		q.push(nvirus[vIdx[i]]);
		arr3[nvirus[vIdx[i]].first][nvirus[vIdx[i]].second] = 1;		
	}

	while (!q.empty()) 
    {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) 
        {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 1 || arr2[nx][ny] != 0 || arr3[nx][ny] == 1) 
                continue;	

			arr2[nx][ny] = arr2[x][y] + 1;
			q.push(make_pair(nx, ny));

			if (arr[nx][ny] == 0) 
            {
				cnt+=1;		
				
                if (maxTime < arr2[nx][ny]) 
                    maxTime = arr2[nx][ny];	
			}

		}

	}

	if (cnt == blank) 
    {			//모든 빈칸에 다 퍼졌으면 
		ansV.push_back(maxTime);
	}
}


void DFS(int toPick, int start) 
{			//전체 바이러스 중 m개 픽

	if (toPick == 0) 
    {
		BFS();
	}

	for (int i = start; i < nvirus.size(); i++) 
    {
		if (visited[i] == 0)
         {
			visited[i] = 1;
			vIdx.push_back(i);

			DFS(toPick - 1, i);
			
            vIdx.pop_back();
			visited[i] = 0;
		}
	}
}


int main() 
{

	cin >> n >> m;

	for (int i = 0; i < n; i++) 
    {
		for (int j = 0; j < n; j++) 
        {
			cin >> arr[i][j];

			if (arr[i][j] == 2) 
            {
				nvirus.push_back(make_pair(i, j));
			}

			else if (arr[i][j] == 0) 
                blank++;
		}
	}

	DFS(m, 0);

	if (ansV.size() == 0) 
        cout << -1;
	
    else 
    {
		sort(ansV.begin(), ansV.end());
		cout << ansV[0];
	}

	return 0;
}