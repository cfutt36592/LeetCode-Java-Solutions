class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        for(int i = 0; i<n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        Arrays.sort(jobs, (a,b) -> a[1] - b[1]);
        
        TreeMap<Integer, Integer> bs = new TreeMap<>();
        bs.put(0,0);
        
        for(int[] job: jobs){
            int val = job[2]+bs.floorEntry(job[0]).getValue();
            if(val>bs.lastEntry().getValue())
                bs.put(job[1], val);
        }
        
        return bs.lastEntry().getValue();
    }
}
