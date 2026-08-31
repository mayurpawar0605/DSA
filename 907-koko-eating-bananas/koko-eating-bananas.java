class Solution {
    static boolean isValidAns(int[] piles,int mid,int h){
        int hourCount = 0;
        for(int i = 0; i < piles.length; i++){
            // if(piles[i] < mid){
            //     hourCount++;
            //     if(hourCount > h){
            //         return false;
            //     }
            // }else{
            //     hourCount++;
            //     int j=2;
            //     while(piles[i] > mid){
            //         hourCount ++;
                    
            //         if(piles[i] < mid * j){
            //             if(hourCount > h){
            //                 return false;
            //             }
            //             break;
            //         }
            //         j++;
                // }

            hourCount += (piles[i] + mid - 1) / mid;
            if(hourCount > h){
                return false;
            }
        }
        return true;
    }

    
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i < n; i++){
            max = Math.max(max,piles[i]);
        }
        int s = 1;
        int e = max;
        int ans = -1;

        // int hour = 0;
        // if(n == 1){
        //     hour += (piles[0] + h - 1) / h;
        //     return hour;
        // }

        while(s <= e){
            int mid = (s + e) / 2;
            if(isValidAns(piles,mid,h)){
                ans = mid;
                e = mid -1;
            }else{
                s = mid + 1;
            }
        }
        return ans;

    }
}