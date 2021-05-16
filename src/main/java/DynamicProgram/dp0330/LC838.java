package DynamicProgram.dp0330;
/*
 * @Description:
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/30 21:52
 */
public class LC838 {

    public static void main(String[] args) {
        LC838 l = new LC838();
        String dominoes = ".L.R...LR..L..";
        String res = l.pushDominoes(dominoes);
        System.out.println(res);
    }


    /**
     int n = dominoes.length();
     int[][] dp = new int[n][n+2];
     -1代表向左, 1代表向右, 0 代表平衡, Integer.MIN_VALUE 代表还不影响
     状态方程 dp[i][j] = 第i秒, j位置上的值
     状态转移方程 dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

     */

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[][] dp = new int[n][n+2];
        char[] arr = dominoes.toCharArray();
        //初始化
        for(int i=0; i<n; i++){
            if(arr[i]=='L'){
                dp[0][i+1] = -1;
            }else if(arr[i]=='R'){
                dp[0][i+1] = 1;
            }else{
                dp[0][i+1] = Integer.MIN_VALUE;
            }
        }
        for(int i=1; i<n; i++){
            //记录本轮是否变化
            int count = 0;
            for(int j=1; j<n+1; j++){
                //照抄
                dp[i][j] = dp[i-1][j];
                if(dp[i][j]!=Integer.MIN_VALUE){
                    //已经平衡或者已经倒了
                    continue;
                }
                //假设当前会变化
                count += 1;
                //当前位置上一秒还是直立
                int left = dp[i-1][j-1];
                int right = dp[i-1][j+1];
                //左右抵消
                if(left==1 && right==-1){
                    dp[i][j] = 0;
                }else if(left==1){
                    //向右
                    dp[i][j] = 1;
                }else if(right==-1){
                    //向左
                    dp[i][j] = -1;
                }else{
                    //当前位置实际没变化
                    count -= 1;
                }
            }
            if(count==0){
                return helper(dp[i]);
            }
        }
        return helper(dp[n-1]);
    }

    public String helper(int[] num){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<num.length-1; i++){
            if(num[i]==-1){
                sb.append('L');
            }else if(num[i]==0 || num[i]==Integer.MIN_VALUE){
                sb.append('.');
            }else{
                sb.append('R');
            }
        }
        return sb.toString();
    }
}
