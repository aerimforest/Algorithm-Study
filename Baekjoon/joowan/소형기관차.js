const { Console } = require('console');
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

function solution() {
  let N = +input[0];
  let people = input[1].split(' ').map(Number);
  let M = +input[2];
  let sumPeople = [0];
  let dp = Array.from({ length: 4 }, () => Array(N + 1).fill(0));
  for (let i = 0; i < N; i++) {
    sumPeople.push(sumPeople[i] + people[i]);
  }

  for (let i = 1; i <= 3; i++) {
    for (let j = i * M; j <= N; j++) {
      dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - M] + (sumPeople[j] - sumPeople[j - M]));
    }
  }
  console.log(dp[3][N]);
}
solution();
