import java.util.*;

class Solution {
    public String solution(String n, int k) {
        StringBuilder sb = new StringBuilder(n);
        for(int i=1; i<sb.length() && k>0; i++) {
            if(i-1<0) continue;
            int l = sb.charAt(i-1) -'0';
            int r = sb.charAt(i) - '0';
            // System.out.println(">> "+(i-1)+"과 "+i+"자리 비교 / "+n.substring(i-1,i));
            if(l == 9) continue;
            if(l < r) { // 작으면
                sb.delete(i-1,i);
                i-=2;
                k--;
            }
        }
        n = sb.toString();
        if(k != 0) n = n.substring(0, n.length()-k); 
        return n;
    }
}