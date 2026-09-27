class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch != ')'){
                stack.push(ch);
            }else{
                //if we get closing bracket
                ArrayList<Character> list = new ArrayList<>();
                while(!stack.isEmpty() && stack.peek() != '('){
                    list.add(stack.pop());
                }
                //remove opening bracket
                stack.pop();
                for(char c : list){
                    stack.push(c);
                }

            }
        }
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        return res.toString();
    }
}