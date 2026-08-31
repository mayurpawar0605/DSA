class Solution {
    static boolean isValidAns(int[] arr,int m,int k,int mid){
        int adjFlowers = 0;
        int bouquetCreated = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= mid){
                adjFlowers ++;
                if(i == arr.length-1){
                    bouquetCreated += adjFlowers / k;
                }
            }else{
                bouquetCreated += adjFlowers / k;
                adjFlowers = 0;
            }
        }
        if(bouquetCreated >= m){
            return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            min = Math.min(bloomDay[i],min);
        }
        for(int i = 0; i < n; i++){
            max = Math.max(bloomDay[i],max);
        }
        int s = min;
        int e = max;
        int ans = -1;

        while(s <= e){
            int mid = s + (e - s) / 2;
            if(isValidAns(bloomDay,m,k,mid)){
                ans = mid;
                e = mid -1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
}