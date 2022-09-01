// 220901_BOJ_1927

#include <iostream>

using namespace std;

int N, heap[100001], heap_size = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        int x;
        cin >> x;

        if (x == 0)
        {
            if (heap_size == 0)
            {
                cout << "0\n";
            }
            else
            {
                cout << heap[1] << "\n";

                // pop
                heap[1] = heap[heap_size--];
                int idx = 1;
                while (idx * 2 <= heap_size)
                {
                    int child = idx * 2;
                    if (idx * 2 + 1 <= heap_size && heap[idx * 2] > heap[idx * 2 + 1])
                    {
                        child = idx * 2 + 1;
                    }

                    if (heap[idx] > heap[child])
                    {
                        swap(heap[idx], heap[child]);
                        idx = child;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        else
        {
            // push
            heap[++heap_size] = x;
            int idx = heap_size;
            while (idx > 1)
            {
                if (heap[idx] < heap[idx / 2])
                {
                    swap(heap[idx], heap[idx / 2]);
                    idx /= 2;
                }
                else
                {
                    break;
                }
            }
        }
    }

    return 0;
}
