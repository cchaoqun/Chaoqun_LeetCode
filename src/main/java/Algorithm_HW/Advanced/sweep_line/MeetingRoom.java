package Algorithm_HW.Advanced.sweep_line;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/11-9:35
 */

public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals==null || intervals.length==0 || intervals[0].length==0){
            return true;
        }
        // 开始时间排序
        Arrays.sort(intervals, (a, b)->(a[0]-b[0]));
        // 当前会议的结束时间
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            // 下一个会议的开始结束时间
            int curEnd = intervals[i][1];
            int curStart = intervals[i][0];
            // 当前会议结束时间早于下次会议开始时间 没有冲突 更新当前会议结束时间为下次会议结束时间
            if(end<=curStart){
                end = curEnd;
            }else{
                // 当前会议结束时间晚于下次会议开始时间, 有冲突
                return false;
            }
        }
        return true;
    }


}

