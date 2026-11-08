
class Solution {

    function twoSum($nums, $target) {

        $arr = [];

        for($i = 0; $i < count($nums); $i++) {

            for($j = $i + 1; $j < count($nums); $j++) {

                if($nums[$i] + $nums[$j] == $target) {

                    $arr[0] = $i;
                    $arr[1] = $j;

                    return $arr;
                }
            }
        }

        return $arr;
    }
}
