class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<1) return intervals;
        
        int n = intervals.length;
        List<int[]> r = new ArrayList<>();
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        for (int[] inter : intervals){            
            if (r.isEmpty() || !overlap(r.get(r.size() - 1), inter)) {
                r.add(inter);
            } else {
                int[] lastInterval = r.get(r.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], inter[1]);                
            }
        }

        return r.toArray(new int[r.size()][]);
    }
    
    public static boolean overlap(int[] a, int[] b){
        return !(a[1] < b[0] || a[0] > b[1]);
    }
}
