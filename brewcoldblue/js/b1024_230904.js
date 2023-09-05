const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on('line', line => {
  const [N, L] = line.split(' ').map(Number);

  const find = (N, L) => {
    for (let length = L; length <= 100; length++) {
      const mid = N / length;
      //나눠서 왼쪽 혹은 중간에 있는 값을 측정함
      //이걸로 L을 먼저 해보고, 안되면 L을 1씩 증가시킬거임
      const start = Math.floor(mid - (length - 1) / 2);
      //얘가 무적권 시작점입니다... 근데 이거 음수나오면 무적권 안됨.
      //예를들어 N=45 L=10에서 4 - (4) = 0 이면 되는건데
      //N=35 L=10에서 음수가 나오면 이거는 시작점이 음수여야되니까 조건에 안맞음
      if (start < 0) continue;

      let sum = 0;
      for (let i = 0; i < length; i++) sum += start + i;
      //얘는 시작점부터 연속된 숫자를 더하는거고
      //그게 N이랑 맞으면
      //배열을 생성하는데요,,, length 길이의 배열을 생성하고, 각 요소에 대해 콜백으로 map을 돌려줌
      //걍 이런게 있길래 한번써봄
      if (sum === N) return Array.from({ length }, (item, idx) => start + idx);
    }
    return false;
  };

  //출력잼
  const result = find(N, L);
  if (result) console.log(result.join(' '));
  else console.log(-1);

  rl.close();
});
