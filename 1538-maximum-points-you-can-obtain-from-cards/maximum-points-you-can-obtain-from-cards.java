class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        for(int i = 0; i < k; i ++){
            leftSum += cardPoints[i];
        }

        int rightSum = 0;
        int maxScore = leftSum;

        //remove last element form leftsum 
        //and add first element from last to rightSUm
        //k-1 index to 0
        int RightIndex = n-1;
        for(int i = k -1; i >= 0; i--){
            //remove leftSum 
            leftSum -= cardPoints[i];
            rightSum += cardPoints[RightIndex];
            RightIndex --;

            maxScore = Math.max(maxScore, leftSum + rightSum);
        }
        return maxScore;
    }
}