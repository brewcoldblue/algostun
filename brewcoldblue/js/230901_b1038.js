const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on('line', input => {
  const N = parseInt(input);

  const find = N => {
    //0~9는 그냥 감소하는 수임
    if (N <= 9) {
      return N;
    }

    // 놀랍게도 이게 큐임
    const Q = [];
    //0~9는 그냥 감소하는 수임
    for (let i = 0; i <= 9; i++) Q.push(i);
    let count = 9;

    while (Q.length) {
      // 큐에서 먼저 들어온 숫자를 빼고
      const num = Q.shift();
      // 그 숫자의 마지막 자릿수를 확인
      const last = num % 10;
      // 마지막 자릿수보다 작은 각 숫자에 대해 새로운 숫자를 생성함
      // 예를 들어 9가 나왔다면, 90~98까지가 감소하는 수임
      // 암튼 0부터 9까지 들어있으니까 10, 20, 30, 31, 32, ... 가 생김
      for (let i = 0; i < last; i++) {
        const newNum = num * 10 + i;
        Q.push(newNum);
        //넣으면서 카운트 증가시킴
        count++;

        // count가 N이면 그게 N번쨰 감소하는 수임
        if (count === N) return newNum;
      }
    }
    return -1;
  };
  console.log(find(N));
  rl.close();
});
