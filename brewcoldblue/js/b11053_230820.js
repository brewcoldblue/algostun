const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let n;
let arr = [];

rl.on('line', line => {
  if (!n) {
    n = parseInt(line);
  } else {
    arr = line.split(' ').map(e => parseInt(e));
    console.log(lip(arr));
    rl.close();
  }
});

function lip(arr) {
  const dp = new Array(arr.length).fill(1);

  for (let i = 1; i < arr.length; i++) {
    for (let j = 0; j < i; j++) {
      if (arr[i] > arr[j]) {
        dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }
  }

  return Math.max(...dp);
}
