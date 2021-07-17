package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/20-10:30
 */

public class Contest_0620_246 {

    @Test
    public void test2(){
        String s1 = "08:31";
        String s2 = "02:07";
        numberOfRounds(s1, s2);
    }


    public int numberOfRounds(String startTime, String finishTime) {
        int startH = Integer.parseInt(startTime.substring(0,2));
        int endH = Integer.parseInt(finishTime.substring(0,2));
        int startM = Integer.parseInt(startTime.substring(3,5));
        int endM = Integer.parseInt(finishTime.substring(3,5));
        int count = 0;
        if(startTime.compareTo(finishTime)<0){
            count += helper(startM, 60);
            count += (endH-(startH+1))*4;
            count += helper(0, endM);
        }else if(startTime.compareTo(finishTime)>0) {
            count += helper(startM, 60);
            count += (24 -(startH+1))*4;
            count += endH*4;
            count += helper(0, endM);
        }else{
            return helper(startM, endM);
        }
        return count;

    }

    private int helper(int m1, int m2){
        int count = 0;
        int start = 0;
        if(m1==0){
            start = 0;
        }else if(m1<=15){
            start = 15;
        }else if(m2<=30){
            start = 30;
        }else if(m2<=45){
            start = 45;
        }else{
            return 0;
        }
        count = Math.max(0, (m2-start)/15);
        return count;

    }

    //========================problem3=========================
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int[][] mask = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mask[i][j] = grid2[i][j];
                if(grid1[i][j]==1 && grid2[i][j]==1){
                    mask[i][j] = 2;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mask[i][j]==2 && !visited[i][j]){
                    count += dfs(mask, visited, i, j)?1:0;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] mask, boolean[][] visited, int row, int col){
        if(!inArea(mask, row, col) || visited[row][col] || mask[row][col]==0){
            return true;
        }
        if(mask[row][col]==1){
            return false;
        }
        visited[row][col] = true;
        boolean up = dfs(mask, visited, row-1, col);
        boolean down = dfs(mask, visited, row+1, col);
        boolean left = dfs(mask, visited, row, col-1);
        boolean right = dfs(mask, visited, row, col+1);
        return up && down && left && right;


    }

    private boolean inArea(int[][] mask, int i, int j){
        return 0<=i && i<mask.length && 0<=j && j<mask[0].length;
    }


    public int[] minDifference(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] indexes = new int[len];
        int[] temp = new int[len];
        for(int i=0; i<len; i++){
            indexes[i] = i;
        }
        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int curMin = mergeSort(nums, indexes, temp, 0, len-1);
            res[i] = curMin;
        }
        return res;
    }

    private int mergeSort(int[] nums, int[] indexes, int[] temp,   int l, int r){
        if(l>=r){
            return 101;
        }
        int mid = l + (r-l)/2;
        int left = mergeSort(nums, indexes, temp, l, mid);
        int right = mergeSort(nums,indexes, temp, mid+1, r);
        int merged = merge(nums, indexes, temp, l, mid, r);
        return Math.min(merged, Math.min(left, right));
    }

    private int merge(int[] nums, int[] indexes, int[] temp, int l, int mid, int r){
        for(int i=l; i<=r; i++){
            temp[i] = indexes[i];
        }
        int minDiff = 101;
        int index = 0;
        int curL = l;
        int curR = mid+1;
        for(int i=l; i<=r; i++){
            if(curL>mid){
                indexes[i]= temp[curR];
                curR++;
            }else if(curR>r){
                indexes[i]= temp[curL];
                curL++;
            }else if(nums[temp[curL]]<nums[temp[curR]]){
                minDiff = Math.min(minDiff, Math.abs(nums[temp[curL]]-nums[temp[curR]]));
                curL++;
            }else if(nums[temp[curL]]>nums[temp[curR]]){
                minDiff = Math.min(minDiff, Math.abs(nums[temp[curL]]-nums[temp[curR]]));
                curR++;
            }else{
                curL++;
            }
        }
        return minDiff;
    }
}
