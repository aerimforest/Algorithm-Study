const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

function solution() {
  let n = +input[0];
  let lossHp = input[1].split(' ').map(Number);
  let pleasure = input[2].split(' ').map(Number);

  let dp = Array.from({ length: n + 1 }, () => Array(101).fill(0));

  for (let i = 1; i < n + 1; i++) {
    for (let j = 0; j < 100; j++) {
      if (j < lossHp[i - 1]) {
        dp[i][j] = dp[i - 1][j];
      } else {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - lossHp[i - 1]] + pleasure[i - 1]);
      }
    }
  }
  console.log(dp[n][99]);
}

solution();
