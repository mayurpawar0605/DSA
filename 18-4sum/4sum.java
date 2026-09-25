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

        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n;i++){
            if(i > 0 && arr[i-1] == arr[i]) continue;

            for(int j = i + 1; j < n;j++){
                if(j > i+1 && arr[j-1] == arr[j]) continue;

                int k = j + 1;
                int l = n -1;
                while(k < l){
                    long sum = arr[i] + arr[j];
                    sum += arr[k] + arr[l];

                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);

                        k++;
                        l--;
                        //we need unique elements
                        while(k < n && arr[k] == arr[k-1]){
                            k++;
                        }while(l > k && arr[l] == arr[l+1]){
                            l--;
                        }

                    }else if (sum > target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return ans;
        

        /*
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
        */
    }
}