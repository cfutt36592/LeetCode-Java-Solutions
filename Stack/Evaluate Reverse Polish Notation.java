class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(tokens[i].equals("-")){
                Integer y = stack.pop();
                Integer x = stack.pop();
                stack.push(x - y);
            }
            else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(tokens[i].equals("/")){
                Integer y = stack.pop();
                Integer x = stack.pop();
                stack.push(x / y);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
