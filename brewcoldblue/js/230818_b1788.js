const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on('line', input => {
  const S = Number(input);
  let N = 1;
  while ((N * (N + 1)) / 2 <= S) N++;

  console.log(N - 1);
  rl.close();
});
