package com.cyn;

/**
 * @author chenyanan
 * Created by chenyanan on 2021/1/8
 * <p>
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
 * <p>
 * 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 5};
        int binarySearchRs = getBinarySearchRs(nums, 5, 3);
        System.out.println("+==" + binarySearchRs);
    }

    public static int getBinarySearchRs(int[] nums, int n, int val) {
        int high = n - 1, low = 0, mid = 0, flag = -1;
        // 如果最低位小于等于最高位一直循环
        while (low <= high) {
            mid = (high + low) / 2;
            // 如果中间值等于给定值就把这个位置给flag
            if (nums[mid] == val) {
                flag = mid;
            }
            // 如果中间值小于给定值，最低位移动，此处是不可以用等号的，此处如果用等号
            // 就会导致第一个重复元素的下标为奇数（下标从0开始）的循环条件 low>high，
            // 最终结果错误。
            if (nums[mid] < val) {
                low = mid + 1;
            }
            // 如果中间值大于等于给定值，指针的最高位移动，之所以这里要用等于，
            // 就是因为此处会存在最低位出现重复元素的情况，比如4,4，10,21
            // mid第一次指向第二个4，但是第二个4并不是答案，所以high还需要移动，
            // 这样原先的flag的值就会被覆写。
            if (nums[mid] >= val) {
                high = mid - 1;
            }
        }
        // 此处直接返回flag即可，不用做判断，如果数组中没有给定值，flag还是初始值-1；
        // 如果有给定值，flag进行了重新赋值，所以无需判断。
        return flag;
    }
}
