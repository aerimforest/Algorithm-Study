from itertools import product

def solution(info, query):
    ans,score = [],[]
    con = [["cpp","java","python"],
          ["backend","frontend"],
          ["junior","senior"],
          ["chicken", "pizza"]]
    db = dict()

    for x in product(*con): db[''.join(x)]=[]
    for ifo in info:
        a = ifo.split(" ")
        db[''.join(a[:-1])].append(int(a[-1]))
        score.append(int(a[-1]))
    for k in db: db[k].sort()
    score.sort()
    S = len(score)

    for qur in query:
        qur = qur.replace("and ", "")
        if "-" in qur: qur=qur.replace("- ","")
        a = qur.split(" ")
        cnt,n = 0,int(a[-1])

        if a[0].isdigit():
            ck,left,right = -1,0,S-1

            while left <= right:
                mid = (left+right)//2
                if score[mid]<n: left=mid+1
                else: ck,right=mid,mid-1
            if ck!=-1: cnt=S-ck
        else:
            for k in db:
                for x in a[:-1]:
                    if x not in k: break
                else:
                    if not db[k]: continue
                    b = db[k]
                    B = len(b)
                    ck,left,right = -1,0,B-1

                    while left <= right:
                        mid = (left+right)//2
                        if b[mid]<n: left=mid+1
                        else: ck,right=mid,mid-1
                    if ck!=-1: cnt+=B-ck
        ans.append(cnt)
    return ans
