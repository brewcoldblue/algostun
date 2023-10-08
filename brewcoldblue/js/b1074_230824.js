const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on('line', line => {
  const [N, r, c] = line.split(' ').map(Number);
  console.log(solution(N, r, c));
  rl.close();
});

function solution(n, r, c) {
  let answer = 0;

  while (n > 0) {
    let half = 1 << (n - 1); // 2^(n-1)
    // 1사분면
    if (r < half && c < half) {
      // do nothing
    }
    // 2사분면
    else if (r < half && c >= half) {
      answer += half * half; // 2^(n-1) * 2^(n-1)
      c -= half;
    }
    // 3사분면
    else if (r >= half && c < half) {
      answer += 2 * half * half;
      r -= half;
    }
    // 4사분면
    else {
      answer += 3 * half * half;
      r -= half;
      c -= half;
    }
    n -= 1;
  }
  return answer;
}
