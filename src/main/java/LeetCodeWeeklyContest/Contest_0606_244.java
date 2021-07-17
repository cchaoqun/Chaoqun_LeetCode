package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/6-10:27
 */

public class Contest_0606_244 {
    public boolean findRotation(int[][] mat, int[][] target) {
        /*
        int m = mat.length
        int n = mat[0].length
        旋转一次 m n
            arr[i][j]->arr[j][m-1-i]
        旋转两次 n m
            arr[j][m-1-i]->arr[m-1-i][n-1-j]
        旋转三次 m n
            arr[m-1-i][n-1-j] -> arr[n-1-j][m-1-(m-1-i)] = arr[n-1-j][i]
        旋转四次 n m
            arr[n-1-j][i] -> arr[i][j]
        旋转方程
        比较相等方程
        */
        return rotate0(mat, target) || rotate1(mat,target);

    }

    public boolean rotate0(int[][] mat, int[][] target){
        int m = mat.length;
        int n = mat[0].length;
        boolean r1 = true;
        boolean r2 = true;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]!=target[i][j]){
                    r1  = false;
                    break;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[m-1-i][n-1-j]!=target[i][j]){
                    r2 = false;
                    break;
                }
            }
        }
        return r1 || r2;
    }

    public boolean rotate1(int[][] mat, int[][] target){
        int m = mat.length;
        int n = mat[0].length;
        boolean r1 = true;
        boolean r2 = true;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[j][m-1-i]!=target[i][j]){
                    r1 =  false;
                    break;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[n-1-j][i]!=target[i][j]){
                    r2 = false;
                    break;
                }
            }
        }
        return r1 || r2;


    }

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int weight = 0;

        for(int i=1; i<nums.length; i++){
            //取出最小的前面几个数
            if(i>0 && nums[i]==nums[0]){
                continue;
            }
            //遇到不相等, 对应的weight+1
            if(nums[i]!=nums[i-1]){
                weight++;
            }
            //当前这个数变成最小值需要weight次操作
            sum += weight;
        }
        return sum;
    }

    public int minFlips(String s) {
        /*
        操作1
            所有的字符都可以在任意位置上
        操作2
            翻转任意一位的数字
        */
        int n = s.length();
        int start = 0;
        while(s.charAt(start)!=s.charAt((start-1+n)%n)){
            start++;
        }
        int[] odd = new int[2];
        int[] even = new int[2];
        int index = 0;
        for(int i=start; i<start+n; i++ ){
            int cur = i%n;
            if(index==0){
                even[s.charAt(cur)-'0']++;
                index = 1;
            }else{
                odd[s.charAt(cur)-'0']++;
                index = 0;
            }
        }
        return Math.min(odd[1]+even[0], odd[0]+even[1]);


    }

    @Test
    public void test1(){
        String s = "10001100101000000";
        int i = minFlips(s);
        System.out.println(i);
    }

    @Test
    public void test2(){

    }

    @Test
    public void test3(){

    }

    @Test
    public void test4(){

    }
}
