public class Solution_표현가능한이진트리 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            // 1. 십진수 -> 이진수 변환
            long number = numbers[i];
            String binaryString = Long.toBinaryString(number);

            // 2. Perfect Binary Tree로 맞춰주기. (0 패딩)
            int length = binaryString.length(); // 이진수로 변환된 문자열 길이 (패딩 전)
            int depthCnt = 1;
            int cnt = 1;

            while (length > cnt) {
                depthCnt *= 2;
                cnt += depthCnt;
            }

            binaryString = "0".repeat(cnt - length) + binaryString;

            // 3. 이진 트리 검증 -> 정답 배열에 저장
            answer[i] = isValid(binaryString.toCharArray(), binaryString.length() / 2, 0, binaryString.length()-1, false) ? 1: 0;
        }
        return answer;
    }

    // 이진 트리 검증 메서드
    private boolean isValid(char[] arr, int rootIdx, int l, int r, boolean shouldBeZero) {
        // 부모가 0인데 자식 노드가 0이 아닐 경우 이진 트리 불가능
        if (shouldBeZero && arr[rootIdx] != '0') return false;
        // 리프노드일 경우, 이진 트리 가능 (앞 조건을 통과해서 이진트리 가능한데 리프노드까지 탐색한 경우)
        if (l >= r) return true;

        int leftMid = (l + rootIdx) / 2;
        int rightMid = (rootIdx+1 + r) / 2;
        boolean isZero = arr[rootIdx] == '0';

        return isValid(arr, leftMid, l, rootIdx-1, isZero) && isValid(arr, rightMid, rootIdx+1, r, isZero);
    }
}
