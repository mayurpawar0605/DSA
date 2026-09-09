class Solution {
    public long countCommas(long n) {
        long ans = 0;

        if (n > 999) {
            ans += Math.min(n, 999999) - 999;
        }

        if (n > 999999) {
            ans += (Math.min(n, 999999999) - 999999) * 2;
        }

        if (n > 999999999) {
            ans += (Math.min(n, 999999999999L) - 999999999) * 3;
        }

        if (n > 999999999999L) {
            ans += (Math.min(n, 999999999999999L) - 999999999999L) * 4;
        }

        if (n > 999999999999999L) {
            ans += (n - 999999999999999L) * 5;
        }

        return ans;
    }
}