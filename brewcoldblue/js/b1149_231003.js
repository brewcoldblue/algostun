const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function calculateMinCost(n, costs) {
  const dp = [];

  dp[0] = costs[0].slice();

  for (let i = 1; i < n; i++) {
    dp[i] = [
      costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]),
      costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]),
      costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]),
    ];
  }

  const result = Math.min(...dp[n - 1]);
  return result;
}

let n;
const costs = [];
let currentIndex = 0;

rl.on('line', input => {
  if (!n) {
    n = parseInt(input);
  } else {
    const costArr = input.split(' ').map(Number);
    costs.push(costArr);
    currentIndex++;

    if (currentIndex === n) {
      const result = calculateMinCost(n, costs);
      console.log(result);
      rl.close();
    }
  }
});
