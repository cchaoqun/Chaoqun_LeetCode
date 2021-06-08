package GreedyAlgorithm.greedy0525;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/25-15:14
 */

public class LC1007 {
    //遍历一次
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int len = tops.length;
        //A[0] A行tops[i]的个数
        //A[1] B行tops[i]的个数(同一列不同的情况)
        int[] A = new int[2];
        //同理
        int[] B = new int[2];
        //A行需要的tops[i]的个数(去掉了两列相等并且等于tops[i]的情况)
        int m = len;
        //B行需要的bottoms[i]的个数(去掉了两列相等并且等于bottoms[i]的情况)
        int n = len;
        int t = tops[0];
        int b = bottoms[0];

        for(int i=0;i<len; i++){
            //两数相等的情况, 如果与其中一个数相等, 对应需要达到的次数-1
            if(tops[i]==bottoms[i]){
                int cur = tops[i];
                if(cur!=t && cur!=b){
                    return -1;
                }
                if(cur==t){
                    m--;
                }
                if(cur==b){
                    n--;
                }
            }else{
                //不相等, 对应的次数+1
                int t1 = tops[i];
                int b1 = bottoms[i];
                //A行的这一列等于tops[0]
                if(t1==t){
                    A[0]++;
                }
                //A行的这一列等于bottoms[0]
                if(t1==b){
                    B[1]++;
                }
                //B行的这一列等于tops[0]
                if(b1==t){
                    A[1]++;
                }
                //B行的这一列等于bottoms[0]
                if(b1==b){
                    B[0]++;
                }
            }
        }
        //遍历两行中1-6的个数是否大于等于需要达到的次数
        for(int i=1; i<7; i++){
            if(A[0]+A[1]>=m){
                return Math.min(A[0], A[1]);
            }else if(B[0]+B[1]>=n){
                return Math.min(B[0], B[1]);
            }
        }
        return -1;
    }
}
class LC1007_M2{

    //找到使得一行全部为target的最小旋转次数, 不可以则return-1;
    public int minReturn(int target, int[] A, int[] B, int len){
        int r1 = 0;
        int r2 = 0;
        for(int i=0; i<len; i++){
            if(A[i]!=target && B[i]!=target){
                return -1;
            }else if(A[i]!=target){
                r1++;
            }else if(B[i]!=target){
                r2++;
            }
        }
        return Math.min(r1, r2);
    }
    //选择两数组第一个元素, 查看是否能够使得某一行全部是t || b
    public int minDominoRotations(int[] tops, int[] bottoms){
        int t = tops[0];
        int b = bottoms[0];
        int len = tops.length;

        int res1 = minReturn(t, tops, bottoms,len);
        if(res1!=-1 || tops[0]==bottoms[0]){
            return res1;
        }else {
            return minReturn(b,tops, bottoms, len);
        }
    }

}































