class Solution {
    static void merge(int[] nums,int s,int e,int mid){
        //create tow arrays -> left and right
        int leftLen = mid + 1 - s;
        int rightLen = e - mid;

        int[] left = new int[leftLen];
        int[] right = new int[rightLen];

        //copy values from nums in left and right array
        int k = s;
        for(int i = 0; i < leftLen + rightLen; i++ ){
            if(i < leftLen){
                left[i] = nums[k];
                k++;
            }else{
                right[i-leftLen] = nums[k];
                k++;
            }
        }

        //merge
        int i = 0;
        int j = 0;
        k = s;

        while(i < leftLen && j < rightLen){
            if(left[i] < right[j]){
                nums[k] = left[i];
                i++;
                k++;
            }else{
                nums[k] = right[j];
                j++;
                k++;
            }
        }
        //if numbers remaining in any of array
        while(i < leftLen){
            nums[k++] = left[i++];
        }
        while(j < rightLen){
            nums[k++] = right[j++];
        }
    }
    static void mergeSort(int[] nums,int s, int e){
        //base case 
        if(s >= e){
            //invalid array and single element
            return;
        }
        int mid = (s + e) / 2;

        //sort left part
        mergeSort(nums,s,mid);

        //sort rigth part
        mergeSort(nums,mid+ 1,e);

        //merge them
        merge(nums,s,e,mid);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}