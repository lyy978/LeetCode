public class SearchTime {
    /**
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * 统计一个数字在排序数组中出现的次数。
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target, boolean lower) {
        //二分法
        int i = 0;
        int j = nums.length - 1;
        int ans = nums.length;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target < nums[mid] || (lower&&target<=nums[mid]) ) {
                j = mid - 1;
                ans = mid;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    public int search(int[] nums,int target){
        int leftIdx = binarySearch(nums,target,true);
        int rightIdx = binarySearch(nums,target,false) - 1;
        if (leftIdx <= rightIdx && rightIdx<nums.length && nums[leftIdx] == target && nums[rightIdx]==target)
            return rightIdx - leftIdx + 1;
        return 0;


    }

}
