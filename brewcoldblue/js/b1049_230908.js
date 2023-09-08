const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
rl.on('line', line => {
  input.push(line);
}).on('close', () => {
  const [끊어진기타줄수, 브랜드수] = input[0].split(' ').map(Number);
  let 패키지가격 = 1001;
  let 낱개가격 = 1001;

  for (let i = 1; i <= 브랜드수; i++) {
    const [p, s] = input[i].split(' ').map(Number);
    패키지가격 = Math.min(패키지가격, p);
    낱개가격 = Math.min(낱개가격, s);
  }

  // 비교해야하는 세 가지 가격을 계산하ㅁ
  const 낱개만 = 끊어진기타줄수 * 낱개가격;
  const 패키지낱개 =
    Math.floor(끊어진기타줄수 / 6) * 패키지가격 +
    (끊어진기타줄수 % 6) * 낱개가격; //패키지 사고 남은거 낱개
  const 패키지만 =
    (Math.floor(끊어진기타줄수 / 6) + (끊어진기타줄수 % 6 !== 0 ? 1 : 0)) *
    패키지가격; //패키지를 무적권 더 사야 됨

  const 답 = Math.min(낱개만, 패키지낱개, 패키지만);
  console.log(답);
});
