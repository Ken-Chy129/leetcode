package leetcode.数组;

/**
 * <pre>
 * <p>最朴素的二分查找问题</p>
 * 
 * 可以采用while循环进行查找，也可以采用递归进行查找
 * 原理都一样，每次选择中间值进行判断，不断缩小查找的区间
 * 左右指针不断靠拢，直到左右指针重叠时如果还找不到，这时要么左指针+1大于右指针，要么右指针-1小于左指针，这时便会结束循环或结束递归
 * 查找区间分为左闭右闭和左闭右开，具体差别会在下面解释
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/2 11:44
 */
public class 二分查找704 {
    public int search1(int[] nums, int target) {
        // 需要注意的是这里右边界是长度-1，因为数组下标从0开始
        // 这里维护的是一个左闭右闭的区间
        return bisection(nums, 0, nums.length-1, target);
    }
    
    // 递归方式
    public int bisection(int[] nums, int left, int right, int target) {
        // 左指针已经位于右指针右边，表示查询不到结果
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;  
        } else if (nums[mid] < target) {
            return bisection(nums, mid+1, right, target);
        } else {
            return bisection(nums, left, mid-1, target);
        }
    }
    
    // 循环方式——左闭右闭（更好理解）
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 1.这里之所以使用的是<=号是因为维护的是左闭右闭的区间，所以两者相等时的值是有意义的
        // 2.如果是左闭右开区间，则上面的right指针不需要-1，直接等于长度
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    // 循环方式——左闭右开
    public int search3(int[] nums, int target) {
        int left = 0, right = nums.length;
        // 这里的长度不需要-1，因为维护的是左闭右开区间
        // 这时候当num<target的时候，right=mid，同理也不需要-1
        // 当num>target的时候，left=mid+1，因为左闭且mid值已经判断过了，可以判断下一个，所以需要加1
        // 循环结束条件：
        //      因为右边是开区间，所以其实在这个位置的值是无效的，所以只需要left<right不需要等于
        //      当相等时已经是取到无效值了就不用继续了
        //      如何理解呢？
        //          出现left=right有两种可能，要么是左边界=mid+1后等于右边界，要么是右边界=mid后等于左边界
        //          如果是左边界=mid+1后等于右边界，因为右边界是开区间，所以其实已经超过范围了，显然就应该结束了
        //          如果是右边界=mid后等于左边界，则mid是在前一轮就判断过的，故也不需要继续这新的一轮循环
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
