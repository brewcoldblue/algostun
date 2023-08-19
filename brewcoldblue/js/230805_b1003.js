const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let dp = [
  [1, 0],
  [0, 1],
];

function fibonacci(n) {
  if (dp[n]) {
    return dp[n];
  } else {
    let arr = [
      fibonacci(n - 1)[0] + fibonacci(n - 2)[0],
      fibonacci(n - 1)[1] + fibonacci(n - 2)[1],
    ];
    dp[n] = arr;
    return arr;
  }
}

let input = [];

rl.on('line', line => {
  input.push(line);
}).on('close', () => {
  let T = Number(input[0]);

  for (let i = 1; i <= T; i++) {
    let n = Number(input[i]);
    let answer = fibonacci(n);
    console.log(answer[0] + ' ' + answer[1]);
  }

  process.exit();
});
//1788
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


rl.on('line', (input) => {
    const S = Number(input);
    let N = 1;
    while ((N*(N+1)/2) <= S) N++;
    
    console.log(N-1);
    rl.close();

