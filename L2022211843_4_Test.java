import org.junit.Assert;
import org.junit.Test;

/**
 * L2022211843_4_Test.java
 * 测试用例设计原则：
 * 1. 等价类划分：针对输入数组中不同类型的情况进行划分，如有序数组、无序数组、所有元素相等、单个元素等。
 * 2. 边界值分析：测试数组长度为1、所有元素相等等特殊情况。
 * 3. 异常情况：测试空数组或不符合条件的数组。
 */
public class L2022211843_4_Test {

    /**
     * 测试目的：测试常规的无序数组中的最大间隔。
     * 测试用例：{3, 6, 9, 1}，期望最大间隔为 3。
     */
    @Test
    public void testMaximumGap1() {
        Solution4 solution = new Solution4();
        int[] nums = {3, 6, 9, 1};
        Assert.assertEquals(3, solution.maximumGap(nums));  // 输出 3
    }

    /**
     * 测试目的：测试只有一个元素的数组，期望返回0，因为没有足够的元素计算间隔。
     * 测试用例：{10}，期望最大间隔为 0。
     */
    @Test
    public void testMaximumGap2() {
        Solution4 solution = new Solution4();
        int[] nums = {10};
        Assert.assertEquals(0, solution.maximumGap(nums));  // 输出 0
    }

    /**
     * 测试目的：测试数组中元素差距非常大的情况。
     * 测试用例：{1, 1000000}，期望最大间隔为 999999。
     */
    @Test
    public void testMaximumGap3() {
        Solution4 solution = new Solution4();
        int[] nums = {1, 1000000};
        Assert.assertEquals(999999, solution.maximumGap(nums));  // 输出 999999
    }

    /**
     * 测试目的：测试数组中混合大小和无序的元素，验证最大间隔的正确性。
     * 测试用例：{3, 1, 7, 9, 6, 2, 8}，期望最大间隔为 3。
     */
    @Test
    public void testMaximumGap4() {
        Solution4 solution = new Solution4();
        int[] nums = {3, 1, 7, 9, 6, 2, 8};
        Assert.assertEquals(3, solution.maximumGap(nums));  // 输出 3
    }

    /**
     * 测试目的：测试所有元素相等的情况，期望返回0。
     * 测试用例：{5, 5, 5, 5}，期望最大间隔为 0。
     */
    @Test
    public void testMaximumGap5() {
        Solution4 solution = new Solution4();
        int[] nums = {5, 5, 5, 5};
        Assert.assertEquals(0, solution.maximumGap(nums));  // 输出 0 (所有元素相等)
    }

    /**
     * 测试目的：测试包含非常大的数字的数组，验证算法的正确性。
     * 测试用例：{1000000000, 1, 100000000, 500000000}，期望最大间隔为 500000000。
     */
    @Test
    public void testMaximumGap6() {
        Solution4 solution = new Solution4();
        int[] nums = {1000000000, 1, 100000000, 500000000};
        Assert.assertEquals(500000000, solution.maximumGap(nums));  // 输出 500000000 (最大差值)
    }
}

