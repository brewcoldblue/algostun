const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split(' ');
const X = parseInt(input[0]);
const Y = parseInt(input[1]);

function f(X, Y) {
  let Z = Math.floor((Y * 100) / X);
  let start = 1; //범위 최솟값
  let end = 1000000000; //범위 최댓값
  let result = -1;

  while (start <= end) {
    //이분탐색 돌림
    //Z와 새로운 승률 100(Y+1)/(X+1) 사이에 정수가 있는지봐야함
    let mid = Math.floor((start + end) / 2);
    let newZ = Math.floor(((Y + mid) * 100) / (X + mid));

    if (newZ > Z) {
      end = mid - 1;
      result = mid;
    } else {
      start = mid + 1;
    }
  }

  return result;
}

console.log(f(X, Y));
