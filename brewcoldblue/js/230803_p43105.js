function solution(triangle) {
  let answer = 0;

  let dp = new Array(triangle.length).fill(0);

  for (let i = 0; i < triangle.length; i++) {
    dp[i] = new Array(triangle.length).fill(0);
  }
  for (let i = 0; i < triangle.length; i++) {
    for (let j = 0; j < triangle[i].length; j++) {
      if (i === 0) dp[i][j] = triangle[i][j];
      else if (j === 0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
      else
        dp[i][j] = Math.max(
          dp[i - 1][j - 1] + triangle[i][j],
          dp[i - 1][j] + triangle[i][j]
        );

      answer = answer < dp[i][j] ? dp[i][j] : answer;
    }
  }

  return answer;
}
