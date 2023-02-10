from collections import defaultdict
import datetime,sys
input = sys.stdin.readline

def formmat_date(date: str) -> list[int]:
    return list(map(int, date.split("-")))

def formmat_time(time: str) -> list[int]:
    return list(map(int, time.split(":")))

def formmat_datetime(date: list[int], time: list[int]):
    return datetime.datetime(date[0], date[1], date[2], time[0], time[1])

def period(rental: datetime, restore: datetime):
    return restore - rental

def delta(on_time: datetime, period: datetime) -> datetime:
    return period - on_time

def formmat_rental_period(l: str):
    return datetime.timedelta(days=int(l[:3]), hours=int(l[4:6]), minutes=int(l[8:10]))

def to_pay(period: datetime):
    return period > datetime.timedelta(hours=0, seconds=0)

record = defaultdict(list)
pay_dict = dict()
# 갯수, 대여기간, 벌금
n,l,f = map(str, input().rstrip().split())
n,f = int(n), int(f)
l = formmat_rental_period(l)

for _ in range(n):
    date, time, part, member = map(str,input().rstrip().split())
    record[(member, part)].append(formmat_datetime(formmat_date(date), formmat_time(time)))
    pay_dict[member] = 0

for member, part in record.items():
    
    retal_period = period(part[0], part[1])
    if to_pay(delta(l, retal_period)):
        pay_dict[member[0]] += (delta(l, retal_period).days)*(f*60*24)+(delta(l, retal_period).seconds//60)*f 
ans = []

# print(pay_dict)
for member, money in pay_dict.items():
    if money > 0:
        ans.append([member, money])
if sum(pay_dict.values()) == 0:
    print(-1)
else:
    ans.sort()
    for member, money in ans:
        print(member, money)
"""
16 001/00:00 4000
2021-01-01 09:12 arduino tony9402
2021-12-31 13:24 arduino tony9402
2021-01-23 14:04 raspberrypi tony9402
2021-02-01 18:21 resistance amsminn
2021-02-03 23:14 transistor codethinking
2021-02-28 23:55 transistor codethinking
2021-02-09 12:45 resistance amsminn
2021-02-13 14:37 raspberrypi tony9402
2021-01-01 09:12 arduino tony9402
2021-01-13 13:24 arduino tony9402
2021-02-15 12:12 raspberrypi q540jh
2021-02-15 12:13 raspberrypi q540jh
2021-01-01 09:12 arduino tony9402
2021-01-01 09:13 monitor chansol
2021-01-01 09:18 arduino tony9402
2021-01-01 09:18 monitor chansol
"""