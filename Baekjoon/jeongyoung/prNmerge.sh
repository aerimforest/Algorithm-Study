#!/bin/sh

# Requirements : Read README file first and follow the instructions

# This shell script automatically creates pull request
# with today's date and labels, 
# and merges with https://github.com/Sigmaflo/Algorithm-Study

gh repo set-default Sigmaflo/Algorithm-Study

# Assumes that the commits are already pushed but just in case
git push

tags="c++,jeongyoung"
today=`date +"%y-%m-%d"`

echo "Today : $today"

# pull request
prNum=`gh pr create --title "[Baekjoon] $today" -l $tags -f | cut -b -50`

echo "pr Num : $prNum"
# merge
gh pr merge -m $prNum

exit 0
