package org.example.minimumSizeSubarraySum;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Example 2:
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class SolutionTest {
    @Test
    public void test() {
        test(7, new int[]{2, 3, 1, 2, 4, 3}, 2);
        test(4, new int[]{1, 4, 4}, 1);
        test(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 0);

        test(7, new int[]{7}, 1);
    }

    @Test
    public void largeArray() {
        try {
            URL resource = this.getClass().getClassLoader().getResource("minimumSizeSubArraySum.txt");
            List<String> strings = Files.readLines(new File(resource.toURI()), StandardCharsets.UTF_8);

            int target = Integer.parseInt(strings.get(0));
            int[] nums = Arrays.stream(strings.get(1)
                            .replaceAll("[\\[|\\]]", "")
                            .split(","))
                    .mapToInt(Integer::valueOf).toArray();

            test(target, nums, 79517);
        } catch (Exception ignore) { }
    }

    public void test(int target, int[] nums, int exceptedResult) {
        Assert.assertEquals(exceptedResult, new Solution().minSubArrayLen(target, nums));
    }
}
