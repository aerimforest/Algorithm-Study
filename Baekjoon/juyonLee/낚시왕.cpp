//17143

#include <iostream>
#include <vector>

using namespace std;
int R, C, M;

struct shark 
{
	int speed, dir, sharkSize,num;
};

vector<shark> arr[102][102];
vector<pair<int, int>> sharkvec; 

bool deathArr[10001]; 

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,1,-1 };
int ans;

void getS(int f) 
{
	for (int i = 1; i <= R; i++) 
    {
		if (!arr[i][f].empty()) 
        {
			ans += arr[i][f][0].sharkSize; 
			deathArr[arr[i][f][0].num] = true;
			arr[i][f].pop_back();

			return;
		}
	}
	return;
}

void moveS() 
{
	vector<shark> tmparr[102][102];

	for (int i = 0; i < M; i++) 
    {
		if (deathArr[i]) continue; 

		int x = sharkvec[i].first; int y = sharkvec[i].second;
		int tmps, tmpd, tmpz;
			tmps = arr[x][y][0].speed;
			tmpz = arr[x][y][0].sharkSize; 
			tmpd = arr[x][y][0].dir;


		int fixexmovecount;
		if (tmpd <= 1) 
        { 
			fixexmovecount = tmps%(2*(R - 1));
			for (int a = 0; a < fixexmovecount; a++) 
            {
				if (x == R) 
                    tmpd = 0; 

				if (x == 1) 
                    tmpd = 1; 

				x += dx[tmpd];
			}
		}
		
        else 
        { 
			fixexmovecount = tmps % (2 * (C - 1));

			for (int a = 0; a < fixexmovecount; a++) 
            {
				if (y == C) 
                    tmpd = 3; 
				if (y == 1) 
                    tmpd = 2; 

				y += dy[tmpd];
			}
		}

		sharkvec[i].first = x; 
        sharkvec[i].second = y;

		if(tmparr[x][y].empty()) 
            tmparr[x][y].push_back({ tmps,tmpd,tmpz,i }); 

		else 
        { 
			if (tmparr[x][y][0].sharkSize < tmpz) 
            {
				deathArr[tmparr[x][y][0].num] = true; 
				tmparr[x][y].pop_back();
				tmparr[x][y].push_back({ tmps,tmpd,tmpz,i });
			}
			
            else 
            { 
				deathArr[i] = true;
			}
		}
	}

	for (int t = 1; t <= R; t++) 
    {
		for (int k = 1; k <= C; k++) 
        {
			arr[t][k] = tmparr[t][k];
		}
	}
	return;
}

int main() 
{
	cin >> R >> C >> M;
	int r, c, s, d, z;
	for (int i = 0; i < M; i++) 
    {
		cin >> r >> c >> s >> d >> z;

		sharkvec.push_back(make_pair(r, c));
		arr[r][c].push_back({s, d - 1, z, i});
	}

	for (int j = 1; j <= C; j++) 
    { 
		getS(j);
		moveS();
	}

	cout << ans;

	return 0;
}