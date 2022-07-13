class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int longestSubstring = 0;
        int windowStart = 0;
        int windowEnd = 0;
        
        while (windowEnd < s.length()) {
            char c = s.charAt(windowEnd);
            if (!seen.contains(c)) {
                seen.add(c);
                int sum = windowEnd - windowStart + 1;
                longestSubstring = Math.max(longestSubstring, sum);
                windowEnd++;
            } else {
                seen.remove(s.charAt(windowStart++));
            }
        }
        return longestSubstring;
    }
}
