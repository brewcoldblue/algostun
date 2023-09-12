const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
rl.on('line', function (line) {
  input.push(line);
}).on('close', function () {
  const T = parseInt(input.shift());
  for (let i = 0; i < T; i++) {
    console.log(isVPS(input[i]));
  }
  process.exit();
});

function VPS(pString) {
  let stack = [];

  for (let char of pString) {
    if (char === '(') {
      stack.push(char);
    } else if (char === ')') {
      if (stack.length === 0 || stack.pop() !== '(') {
        return 'NO';
      }
    }
  }

  return stack.length === 0 ? 'YES' : 'NO';
}
