class Solution {
    public int leastInterval(char[] tasks, int n) {
        //could use max heap instead
        int[] charMap = new int[26];
        for(char c: tasks){
            charMap[c - 'A']++;
        }
        
        Arrays.sort(charMap);
        int maxVal = charMap[25] - 1;
        int idleSlots = maxVal * n;
        
        for(int i = 24; i >= 0; i--){
            idleSlots -= Math.min(charMap[i], maxVal);
        }
        
        if(idleSlots > 0) return tasks.length + idleSlots;
        else return tasks.length;  
    }
}
