//20055

#include <iostream>
#define MAX 201

using namespace std;

int n, k, up, down, cnt, ans;
int arr[MAX], robo[MAX];
int i, j;


int main()
{
    cin >> n >> k;

    for (int k = 0; k < 2 * n; k++)
    {
        cin >> arr[k];
    }

    up = 0;  
    down = n - 1;  

    while (1)
    {
        ans++;
    
        robo[down] = 0;
        up--;
        down--;

        if (up == -1) 
            up = 2 * n - 1;

        if (down == -1) 
            down = 2 * n - 1;
        
        i = up;
        
        while (i != down)
        {
            i++;
            if (i == 2 * n) 
                i = 0;
        }
        
        robo[i] = 0;
        
        j = i;

        while (i != up)
        {
            i--;
            if (i == -1) 
                i = 2 * n - 1;

            if (robo[i] == 1 && robo[j] == 0 && 0 < arr[j])
            {
                robo[i] = 0;
                robo[j] = 1;
                arr[j]--;

                if (arr[j] == 0) 
                    cnt++;
            }
            j = i;
        }

        if (0 < arr[i])
        {
            robo[i] = 1;
            arr[i]--;

            if (arr[j] == 0)
                 cnt++;
        }

        if (k <= cnt) 
            break;
    }

    cout << ans << '\n';
    return 0;
}