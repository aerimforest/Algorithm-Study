// 220901_BOJ_2075

#include <iostream>

using namespace std;

int N;
int heap[1502], heap_size = 0;

void push(int x)
{
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
void pop()
{
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

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int j = 0; j < N; ++j)
    {
        int x;
        cin >> x;

        push(x);
    }
    for (int i = 1; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            int x;
            cin >> x;

            if (heap[1] < x)
            {
                pop();
                push(x);
            }
        }
    }

    cout << heap[1];

    return 0;
}
