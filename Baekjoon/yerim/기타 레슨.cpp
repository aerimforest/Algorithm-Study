// [2343] 기타 레슨
#include <iostream> 
#include <algorithm> // max_element(포인터 반환 -> * 필요)
using namespace std; 

int n, m, lesson[100001]; 

int findMinblueRaySize(int initBlueRaySize) 
{ 
    int ans = 1000000000, mid, bluRay = 0, sum = 0; 
    int left = *max_element(lesson, lesson + n); // 최소 블루레이 길이 = 가장 긴 레슨의 길이
    int right = initBlueRaySize; 

    while (left <= right) { 
        mid = (left + right) / 2; 
        bluRay = 0, sum = 0;

        for (int i = 0; i < n; i++) { 
            sum += lesson[i]; 
            if (sum > mid) { 
                bluRay++; // 필요한 블루레이 개수 1증가
                sum = lesson[i]; // 다음 블루레이에 현재 강의 삽입
            } 
        } 

        if (sum <= mid) bluRay++; 

        if (bluRay <= m) { 
            right = mid - 1; 
            ans = min(ans, mid); 
        } 
        else { 
            left = mid + 1; 
        } 
    } 
    return ans; 
} 

int main() 
{  
    int sum = 0; 
    cin >> n >> m; 

    for (int i = 0; i < n; i++) { 
        cin >> lesson[i]; 
        sum += lesson[i]; 
    } 
    cout << findMinblueRaySize(sum) << '\n'; 
    return 0; 
}