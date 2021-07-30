package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/25-10:28
 */

public class Contest_0725_251 {
    @Test
    public void test(){
        String num = "214010";
        int[] change = {6,7,9,7,4,0,3,4,4,7};
        String res = maximumNumber(num ,change);
        System.out.println(res);
    }

    public String maximumNumber(String num, int[] change) {
        StringBuffer sb  = new StringBuffer();
        int l = 0;
        while(l<num.length()){
            char cur = num.charAt(l);
            int ccur = change[cur-'0'];
            if(ccur<= cur-'0'){
                sb.append(cur);
                l++;
                continue;
            }
            while(l<num.length()){
                cur = num.charAt(l);
                ccur = change[cur-'0'];
                if(!greater(ccur, cur)){
                    break;
                }
                sb.append((char)(ccur+'0'));
                l++;
            }
            sb.append(num.substring(l, num.length()));
            break;

        }
        return sb.toString();
    }

    private boolean greater(int num, char c){
        return num >=( c-'0');
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        /**
         a ^ b >>1 记录1的个数res students[0].length-res

         */

        int len = students.length;
        int[] arrS = getNum(students);
        int[] arrM = getNum(mentors);
        int res = 0;
        boolean[] visitM = new boolean[len];
        int[] max = {0};
        backtrack(arrS, arrM,  visitM, 0, max, 0, students[0].length);
        return max[0];

    }

    private void backtrack(int[] arrS, int[] arrM, boolean[] visitM, int index, int[] max, int sum, int bitSize){
        // if(max[0] == arrS.length){
        //     return ;
        // }
        if(index==arrS.length){
            max[0] = Math.max(sum, max[0]);
            return;
        }
        for(int i=0; i<arrS.length; i++){
            if(visitM[i]){
                continue;
            }
            visitM[i] = true;
            int cur = bitSize - getOne(arrS[index]^arrM[i]);
            backtrack(arrS, arrM, visitM, index+1, max, sum+cur, bitSize);

            visitM[i] = false;
        }
    }

    private int getOne(int num){
        int res = 0;
        while(num!=0){
            res += (num&1);
            num >>>=1;
        }
        return res;
    }

    private int[] getNum(int[][] matrix){
        int[] res = new int[matrix.length];
        for(int i=0; i<matrix.length; i++){
            res[i] = getBit(matrix[i]);
        }
        return res;
    }

    private int getBit(int[] arr){
        int res = 0;
        for(int i=arr.length-1; i>=0; i--){
            res += arr[i];
            res<<=1;
        }
        return res;
    }
}
