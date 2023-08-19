const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const tc = parseInt(input[0], 10);
const cmds = input.slice(1);

for (let i = 0; i < tc; i++) {
  const commands = cmds[i].split('');
  const left = [];
  const right = [];

  for (const cmd of commands) {
    switch (cmd) {
      case '<':
        if (left.length) {
          right.push(left.pop());
        }
        break;
      case '>':
        if (right.length) {
          left.push(right.pop());
        }
        break;
      case '-':
        if (left.length) {
          left.pop();
        }
        break;
      default:
        left.push(cmd);
    }
  }

  const pw = left.join('') + right.reverse().join('');
  console.log(pw);
}
