import sys

input = sys.stdin.readline

n = int(input())
ips = [sys.stdin.readline().rstrip().split('.') for i in range(n)]
net_addr = []
net_mask = []

for i in range(4):
    min_ip = int(ips[0][i])
    max_ip = int(ips[0][i])
    for tmp_ip in ips:
        if max_ip < int(tmp_ip[i]):
            max_ip = int(tmp_ip[i])
        if min_ip > int(tmp_ip[i]):
            min_ip = int(tmp_ip[i])
    if 255 == 256 + (~max_ip ^ min_ip):
        net_mask.append(255)
    else:
        for j in range(9):
            if -(~max_ip ^ min_ip) <= 1 << j:
                net_mask.append(256 - (1 << j))
                for k in range(3):
                    net_mask.append(0)
                break
    net_addr.append(int(ips[0][i]) & net_mask[i])
net_mask = net_mask[:4]
print("{}.{}.{}.{}".format(net_addr[0], net_addr[1], net_addr[2], net_addr[3]))
print("{}.{}.{}.{}".format(net_mask[0], net_mask[1], net_mask[2], net_mask[3]))