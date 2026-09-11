class Solution {
    static void solve(int[] digits, int index, int[] output,boolean[] visited,Set<Integer> set){
        //base case -> number is valid and even
        if(index >= 3){
            if(output[0] == 0){
                return;
            }
            if(output[2] % 2 == 0){
                int num = output[0] * 100 +
                            output[1] * 10 +
                            output[2];
                set.add(num);
            }
            return;
        }
        int ans = 0;
        for(int i = 0; i < digits.length; i++){
            if(!visited[i]){
                visited[i] = true;

                output[index] = digits[i];
                
                solve(digits,index + 1,output,visited ,set);
                
                visited[i] = false;
            }
        }

    }
    public int totalNumbers(int[] digits) {
        int index = 0;
        int[] output = new int[3];
        boolean[] visited = new boolean[digits.length];
        Set<Integer> set = new HashSet<>();
        solve(digits,index,output,visited,set);
        return set.size();
    }
}