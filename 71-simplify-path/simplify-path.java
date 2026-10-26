class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();

        String[] parts = path.split("/");

        for(String part : parts){
            if(part.isEmpty()){
                continue;
            }
            else if(part.equals(".")){
                continue;
            }
            else if(part.equals("..")){
                if(st.isEmpty()){
                    continue;
                }else{
                    st.pop();
                }
            }
            else{
                st.push(part);
            }

        }

        if(st.isEmpty()){
            //root directory
            return "/";
        }else{
            //build ans
            StringBuilder str = new StringBuilder();
            while(!st.isEmpty()){
                str.append("/");
                str.append(st.removeLast());
            }

            return str.toString();
        }
    }
}