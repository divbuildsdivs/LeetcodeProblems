class Twitter {
    private static int timestamp = 0; 
    private Map<Integer, User> userMap;

    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweethead;

        public User(int id) {
            this.id =id;
            followed = new HashSet<>();
            follow(this.id); //User should follow themselves to see there recent tweets
            tweethead = null;
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            if(id != this.id){
                followed.remove(id);
            }
        }
        public void post(int id){
            Tweet newtweet = new Tweet(id);
            newtweet.next = tweethead;
            tweethead = newtweet;
        }
    }

    private class Tweet {
        int tweetId;
        int time;
        Tweet next;
        public Tweet(int id) {
            this.tweetId = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    public Twitter() {
        this.userMap  = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new LinkedList<>();
        if(!userMap.containsKey(userId)){
            return newsFeed;
        }
        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue((a,b)-> b.time - a.time);
        for(int followedUser: followedUsers ){
            Tweet nextTweet = followedUser.tweethead;
            while(nextTweet != null){
                tweetHeap.add(nextTweet);
                nextTweet = nextTweet.next;
            }
        }
        int tweetCount = 0;
        while(!tweetHeap.isEmpty() && tweetCount < 10){
           newsFeed.add(tweetHeap.poll());
        }
        return newsFeed;
        
    }
    
    public void follow(int followerId, int followeeId) {
         if(!userMap.containsKey(followerId)){
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if(!userMap.containsKey(followeeId)){
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId) && followerId != followeeId ){
             userMap.get(followerId).unfollow(followeeId);
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