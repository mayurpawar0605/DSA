class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // int x1r1 = rec1[0];
        // int y1r1 = rec1[1];
        // int x2r1 = rec1[2];
        // int y2r1 = rec1[3];

        // int x1r2 = rec2[0];
        // int y1r2 = rec2[1];
        // int x2r2 = rec2[2];
        // int y2r2 = rec2[3];

        // // x-axis overlap
        // boolean xOverlap = x1r1 < x2r2 && x1r2 < x2r1;

        // // y-axis overlap
        // boolean yOverlap = y1r1 < y2r2 && y1r2 < y2r1;

        // return xOverlap && yOverlap;




        //we have to find common area 
        //width min of x2 - max of x1
        int width = Math.min(rec1[2],rec2[2]) - Math.max(rec1[0],rec2[0]);

        //heigth min of y2 - max of y1
        int heigth = Math.min(rec1[3],rec2[3]) - Math.max(rec1[1],rec2[1]);

        return width > 0 && heigth > 0;

    }
}