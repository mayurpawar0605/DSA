class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {

        /*
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();

        for(int i = 0; i < n;i++){
            for(int j = i + 1; j < n;j++){
                for(int k = j + 1; k <n; k++){
                    for(int l =k + 1; l < n; l++){
                        if(arr[i] + arr[j] + arr[k] + arr[l] == target){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add(arr[k]);
                            temp.add(arr[l]);
                            Collections.sort(temp);
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ans);

        */

        /*
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();

        for(int i = 0; i < n;i++){
            for(int j = i + 1; j < n;j++){
                int k = j + 1;
                int l = n -1;
                while(k < l){
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        Collections.sort(temp);
                        ans.add(temp);
                        k++;
                    }else if (sum > target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return new ArrayList<>(ans);
        */

        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();

        for(int i = 0; i < n;i++){
            for(int j = i + 1; j < n;j++){

                Set<Long> set = new HashSet<>();
                for(int k = j + 1; k <n; k++){
                    long forth =(long) target - arr[i] - arr[j] - arr[k];

                    if(set.contains(forth)){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add(arr[k]);
                            temp.add((int)forth);
                            Collections.sort(temp);
                            ans.add(temp);
                    }
                    set.add((long)arr[k]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}