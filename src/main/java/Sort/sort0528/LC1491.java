package Sort.sort0528;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/28-13:20
 */

public class LC1491 {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int sum = 0;
        for(int i:salary){
            sum+=i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return (sum-max-min)*1.0/(salary.length-2);
    }
}
