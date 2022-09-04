#!/bin/bash

num=$1
name=$2

git add "$name.py"
git status
echo "Would you commit? Enter y for agreement"
read answer
if [ $answer == 'y' ]
then
		git commit -m "[$num] $name"
fi

