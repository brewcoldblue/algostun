const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
let lines = 2;

rl.on('line', line => {
  input.push(line);
  lines--;
  if (lines === 0) rl.close();
}).on('close', () => {
  let [N, score, P] = input[0].split(' ').map(Number);
  const ranking = N ? input[1].split(' ').map(Number) : []; // N이 0일 때의 예외처리

  if (N === P && score <= ranking[P - 1]) {
    console.log(-1);
    return;
  }
  for (let i = 0; i < N; i++) {
    if (ranking[i] <= score) {
      console.log(i + 1);
      return;
    }
  }
  console.log(N + 1);
});
