class Solution {
    int row,col;
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int area = brown + yellow; // 전체 격자 수
        for(int i=1;i<=area;i++){
            int row = i;
            int col = area/i; // 나누는 수, 나눠지는 수 헷갈리지 말기
            if(yellow==(row-2)*(col-2)){
                answer[0]=row;
                answer[1]=col;
            }
        }
        
        return answer;
    }
}
