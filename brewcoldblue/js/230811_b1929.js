const fs = require('fs');

const input = fs
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(' ')
  .map(Number);
const [M, N] = input;

const np = new Array(N + 1).fill(false);
np[0] = true;
np[1] = true;

for (let i = 2; i <= Math.sqrt(N); i++) {
  if (!np[i]) {
    for (let j = i ** 2; j <= N; j = j + i) {
      np[j] = true;
    }
  }
}

for (let i = M; i <= N; i++) {
  if (!np[i]) {
    console.log(i);
  }
}
