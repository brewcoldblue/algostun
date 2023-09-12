const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let lines = 0;
let cases = 0;

rl.on('line', line => {
  input.push(line.trim().split(' ').map(Number));
  lines++;
  if (
    lines - 1 ===
    input[0][0] +
      input
        .slice(1)
        .reduce((acc, val, idx) => (idx % 2 === 0 ? acc + val[2] : acc), 0)
  ) {
    rl.close();
  }
});

rl.on('close', () => {
  main(input);
  process.exit();
});

function bfs(x, y, field, visited) {
  const queue = [[x, y]];
  visited[y][x] = true;

  const directions = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];

  while (queue.length > 0) {
    const [curX, curY] = queue.shift();

    for (const [dx, dy] of directions) {
      const newX = curX + dx;
      const newY = curY + dy;

      if (
        newX >= 0 &&
        newX < field[0].length &&
        newY >= 0 &&
        newY < field.length &&
        !visited[newY][newX] &&
        field[newY][newX] === 1
      ) {
        visited[newY][newX] = true;
        queue.push([newX, newY]);
      }
    }
  }
}

function main(input) {
  let idx = 1;
  for (let i = 0; i < input[0][0]; i++) {
    const [M, N, K] = input[idx++];
    const field = Array.from({ length: N }, () => Array(M).fill(0));
    const visited = Array.from({ length: N }, () => Array(M).fill(false));

    for (let j = 0; j < K; j++) {
      const [x, y] = input[idx++];
      field[y][x] = 1;
    }

    let wormCount = 0;
    for (let y = 0; y < N; y++) {
      for (let x = 0; x < M; x++) {
        if (field[y][x] === 1 && !visited[y][x]) {
          bfs(x, y, field, visited);
          wormCount++;
        }
      }
    }

    console.log(wormCount);
  }
}
