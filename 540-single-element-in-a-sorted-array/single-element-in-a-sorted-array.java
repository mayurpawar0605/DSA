class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;

        while(s <= e){
            int mid = (s + e) / 2;
            int startingIdx = -1;

            //find startingIdx of pair if pair not exists return 
            if(mid+1 < n && nums[mid] == nums[mid+1]){
                startingIdx = mid;
            }else if(mid-1 >= 0 && nums[mid] == nums[mid-1]){
                startingIdx = mid -1;
            }else{
                return nums[mid];
            }

            //check startingIdx is even or odd
            if((startingIdx & 1) == 0) {
                //even -> single element is in right
                s = mid + 1;
            }else{
                //odd -> single element is in left
                e = mid -1;
            }
        }
        return -1;
    }
}