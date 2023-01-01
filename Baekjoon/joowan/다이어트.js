const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

function solution() {
  let G = +input[0];
  let start = 1;
  let end = 2;
  let flag = 0;

  while (start < end) {
    res = end ** 2 - start ** 2;
    if (res >= G) {
      start += 1;
      if (res === G) {
        console.log(end);
        flag = 1;
      }
    } else end += 1;
  }
  if (flag === 0) console.log(-1);
}
solution();
