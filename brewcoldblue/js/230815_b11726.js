const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on('line', function (line) {
  const n = parseInt(line);
  console.log(wow(n));
  rl.close();
}).on('close', function () {
  process.exit();
});

function wow(n) {
  if (n === 1) return 1;
  if (n === 2) return 2;

  const dp = Array(n + 1).fill(0);
  dp[1] = 1;
  dp[2] = 2;

  for (let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
  }

  return dp[n];
}
