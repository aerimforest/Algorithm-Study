#!/bin/sh

# Requirements : Do following instructions before executing this.
# 1. install `gh cli`
# 2. login with `gh auth login`
# 3. stage and commit the changes

# This shell script automatically creates pull request
# with today's date and labels, 
# and merges with https://github.com/Sigmaflo/Algorithm-Study

# FIX THIS AS YOU LIKE
tags="c++,jeongyoung"

gh repo set-default Sigmaflo/Algorithm-Study

# Assumes that the commits are already pushed but just in case
git push

today=`date +"%y-%m-%d"`

echo "Today : $today"

# pull request
prNum=`gh pr create --title "[Baekjoon] $today" -l $tags -f -b ""`

echo "$prNum"
# merge
gh pr merge -m $prNum

exit 0
