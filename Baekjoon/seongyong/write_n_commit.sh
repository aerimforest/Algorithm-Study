#!/bin/bash

echo "Enter number of problem"
read num

echo "Enter name of problem"
read name

vim "$name.py"
git add "$name.py"
git status
echo "Wanna commit? Enter y for agreement"
read answer
if [ $answer == 'y' ]
then
		git commit -m "[$num] $name"
fi

