(function solution() {
  const people = 6;
  const friends = [
    [1, 2],
    [1, 4],
    [2, 3],
    [2, 4],
    [3, 4],
    [3, 5],
    [3, 6],
    [4, 5],
    [4, 6],
    [5, 6],
  ];
  console.log(findGroup(people, friends));
})();

function findGroup(people, friends) {
  const graph = new Array(people + 1).fill().map(() => []);

  for (let [f1, f2] of friends) {
    graph[f1].push(f2);
    graph[f2].push(f1);
  }

  const visited = new Set();
  let 강력한친구그룹 = 0;

  for (let person = 1; person <= people; person++) {
    if (!visited.has(person)) {
      const 그룹 = bfs(graph, person, visited);
      //여기서 1번부터 돌면서 그룹의 크기를 1 depth마다 재서 비교하고싶음...근데 못하겠음 ㅠ
      강력한친구그룹 = Math.max(강력한친구그룹, 그룹);
    }
  }

  return 강력한친구그룹;
}
