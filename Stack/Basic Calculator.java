class Solution {
    public int calculate(String s) {
        int sign = 1;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                int num = 0;
                while(i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                sum += num*sign;
                i--;
            }
            else if(c == '+'){
                sign = 1;
            }
            else if(c == '-'){
                sign = -1;
            }
            else if(c == '('){
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(c == ')'){
                sum *= stack.pop(); //sign
                sum += stack.pop(); //num
            }
        }
        
        return sum;
    }
}
