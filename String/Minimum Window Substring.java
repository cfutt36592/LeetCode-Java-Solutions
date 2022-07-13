class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> goal = new HashMap<>();
        int goalSize = t.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        //target dictionary
        for(int k=0; k<t.length(); k++){
            char letter = t.charAt(k);
            goal.put(letter, goal.getOrDefault(letter, 0)+1);
        }

        int left=0;
        int total=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(!goal.containsKey(c)){
                continue;
            }

            //if c is a target character in the goal, and count is < goal, increase the total
            int count = map.getOrDefault(c, 0);
            if(count<goal.get(c)){
                total++;
            }

            map.put(c, count+1);

            //when total reaches the goal, trim from left until no more chars can be trimmed.
            if(total==goalSize){
                while(!goal.containsKey(s.charAt(left)) || map.get(s.charAt(left))>goal.get(s.charAt(left))){
                    char pc = s.charAt(left);
                    if(goal.containsKey(pc) && map.get(pc)>goal.get(pc)){
                        map.put(pc, map.get(pc)-1);
                    }

                    left++;
                }

                if(minLen>right-left+1){
                        minLen = right-left+1;
                        result = s.substring(left, right+1);
                }
            }            
        }

        return result;
    }
}
