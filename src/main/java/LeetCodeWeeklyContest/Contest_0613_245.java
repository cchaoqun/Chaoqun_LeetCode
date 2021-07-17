package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/13-10:39
 */

public class Contest_0613_245 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        /*根据 triplets[i][0]排序
        需要保证所有下标<i的当中有 target[1] target[2]  并且 triplets[i][1]<=target[1]  triplets[i][2]<=target[2]
        */
        Arrays.sort(triplets, (o1, o2)->(o1[0]-o2[0]));
        int index = 0;
        boolean t1 = false;
        boolean t2 = false;
        boolean t3 = false;
        int n = triplets.length;
        while(index<n && triplets[index][0]<=target[0]){
            if(triplets[index][1]==target[1] && triplets[index][2]<=target[2] ){
                t1 = true;
            }
            if(triplets[index][2]==target[2] && triplets[index][1]<=target[1] ){
                t2 = true;
            }
            if(triplets[index][0]==target[0] && triplets[index][1]<=target[1] && triplets[index][2]<=target[2] ){
                t3 = true;
            }
            index++;
        }
        return t1 && t2 && t3;

    }

    @Test
    public void test(){
        String s  = "rqmvwezfxczzeqokjww";
        String p = "rezxczzeqw";
        int[] removable = {18,1,3,7,4,16,14,2,15,0,6,12,17,11,13,5,9};
        maximumRemovals(s,p,removable);
    }



    public int maximumRemovals(String s, String p, int[] removable) {
        //二分查找removable的下标, 对于每个mid 将[0,mid]对应位置的数都删了
        int left = 0;
        int right = removable.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            StringBuffer sb = new StringBuffer(s);
            //删除remoable[0,mid]对应下标位置下的字符
            for(int i=0; i<=mid; i++){
                sb.setCharAt(removable[i], ' ');
            }
            //如果p不再是删除后的字符串s的子序列, 则可以删除的长度肯定小于mid
            if(!isSubsequence(sb.toString(), p)){
                right = mid-1;
            }else{
                //可以删除就向右找
                left = mid+1;
            }
        }
        return right+1;


    }

    //判断p是否是s的子串
    private boolean isSubsequence(String s, String p){
        int lenS = s.length();
        int lenP = p.length();
        int i=0;
        int j=0;
        while(i<lenS && j<lenP){
            //两个字符相等 两个指针都移动
            if(s.charAt(i)==p.charAt(j)){
                j++;
            }
            i++;
        }
        //匹配完 子序列的指针是否移动到子序列的长度
        return j==lenP;
    }
}
