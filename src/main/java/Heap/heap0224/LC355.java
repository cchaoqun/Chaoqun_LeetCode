package Heap.heap0224;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/10-14:10
 */

public class LC355 {


}

class Twitter {

    //用户id和对应的tweet链表的map
    private Map<Integer, Tweet> twitter;

    //用户id和对应的关注的人的set的map
    private Map<Integer, Set<Integer>> followings;

    //存放某用户和关注的人的tweet的链表的堆
    private PriorityQueue<Tweet> maxHeap;

    //时间戳,每条推特发送前都会+1
    private int timestamp = 0;



    /** Initialize your data structure here. */
    public Twitter() {
        twitter = new HashMap<>();
        followings = new HashMap<>();
        //最大堆
        maxHeap = new PriorityQueue<>((o1,o2)->o2.timeStamp-o1.timeStamp);
    }


    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        //该用户对应的tweet链表
        if(twitter.containsKey(userId)){
            //插入tweet链表头
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId,newHead);
        }else{
            //该用户当前第一次发tweet, 创建一条新的tweet链表
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        //全局变量, 使用前需要清空
        maxHeap.clear();
        //自己的tweet链表
        if(twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }
        //userId关注的人的tweet链表
        Set<Integer> followList = followings.get(userId);
        //有关注的人
        if(followList!=null && followList.size()!=0){
            //遍历关注的每个人
            for(Integer followId:followList){
                //当前关注的人有tweet链表
                Tweet tweet = twitter.get(followId);
                if(tweet!=null){
                    maxHeap.offer(tweet);
                }
            }
        }
        //userId自己的tweet和关注的人的tweet已经添加到maxHeap
        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while(!maxHeap.isEmpty() && count<10){
            //堆顶时间戳最大的tweet出堆, 时间越大表示越近
            Tweet tweet = maxHeap.poll();
            //tweetId放入res
            res.add(tweet.tweetId);
            //链表后移
            tweet = tweet.next;
            //不为空继续加入maxHeap
            if(tweet!=null){
                maxHeap.offer(tweet);
            }
            count++;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        //不能关注自己
        if(followeeId==followerId){
            return;
        }
        //获取followerId的关注set
        Set<Integer> followList = followings.get(followerId);
        if(followList==null){
            //创建对应的关注列表
            Set<Integer> init = new HashSet<>();
            //加入关注列表
            init.add(followeeId);
            //放入followings的map
            followings.put(followerId, init);
        }else{
            //已经关注过
            if(followList.contains(followeeId)){
                return ;
            }
            //添加到关注列表
            followList.add(followeeId);

        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId==followerId){
            return;
        }
        //获取关注列表
        Set<Integer> followList = followings.get(followerId);
        if(followList==null || followList.size()==0){
            return;
        }
        followList.remove(followeeId);
    }
    private class Tweet{
        /*
        tweet id
         */
        public int tweetId;
        /*
        tweet对应的时间戳
         */
        public int timeStamp;
        /*
        下一条tweet
         */
        public Tweet next;


        public Tweet(int tweetId, int timeStamp){
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
}





/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */