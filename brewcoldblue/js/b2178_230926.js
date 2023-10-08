const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
rl.on('line', function (line) {
  input.push(line);
}).on('close', function () {
  const [N, M] = input[0].split(' ').map(Number);
  const maze = input.slice(1).map(row => row.split('').map(Number));

  const dx = [1, 0, -1, 0];
  const dy = [0, 1, 0, -1];

  function bfs(x, y) {
    const queue = [[x, y]];

    while (queue.length) {
      const [currX, currY] = queue.shift();
      for (let i = 0; i < 4; i++) {
        const nextX = currX + dx[i];
        const nextY = currY + dy[i];

        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
        if (maze[nextX][nextY] === 0 || maze[nextX][nextY] > 1) continue;

        queue.push([nextX, nextY]);
        maze[nextX][nextY] = maze[currX][currY] + 1;
      }
    }
  }

  bfs(0, 0);
  console.log(maze[N - 1][M - 1]);
  process.exit();
});
