import java.util.Arrays;

/**
 * @description:
 * 
 * 给定一个无序的数组 nums，返回数组在排序之后，相邻元素之间的最大差值。如果数组元素个数小于 2，则返回 0。
 * 
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 * 
 * 示例 1:
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9]，其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 
 * 示例 2:
 * 输入: nums = [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 
 * 提示:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 */
class Solution4 {
    public int maximumGap(int[] nums) {
        // 获取数组的长度
        int n = nums.length;

        // 如果数组元素个数小于 2，直接返回 0
        if (n < 2) {
            return 0;
        }

        // 初始化用于存放结果的变量
        int ret = 0;

        // 确定最大值以确定需要处理的数字位数
        int maxVal = Arrays.stream(nums).max().getAsInt();

        // 处理每一位数，从低位到高位
        for (long exp = 1; maxVal / exp > 0; exp *= 10) {
            // 创建计数数组用于记录每个数字的出现次数
            int[] cnt = new int[10];

            // 遍历原数组，根据当前位数的数字进行计数
            for (int i = 0; i < n; i++) {
                // 计算当前数字在该位上的值（0-9）
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }

            // 计算累积计数，以便排序
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1]; // cnt[i] 存储当前数字的最终位置
            }

            // 创建临时数组 buf 来存放排序后的结果
            int[] buf = new int[n];
            // 反向填充 buf 数组，确保稳定性
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i]; // 将数字放到其正确的位置
                cnt[digit]--; // 减少当前数字的计数
            }

            // 将排序后的数组复制回原数组
            System.arraycopy(buf, 0, nums, 0, n);
        }

        // 在排序后的数组中查找最大相邻差值
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]); // 计算相邻元素之间的差值
        }
        
        return ret; // 返回最大相邻差值
    }
}
