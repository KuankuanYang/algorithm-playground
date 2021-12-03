package io.kuankuan.leetcode;

/**
 * @author Kuankuan Yang
 * @date 2021-12-02 11:34
 */
public class Problem55 {

    /**
     * 回溯（Time Limit Exceeded）
     */
    private class Backtracking {
        public boolean canJump(int[] nums) {
            return canJumpFromPosition(0, nums);
        }

        private boolean canJumpFromPosition(int position, int[] nums) {
            // 当前位置为目标位置，返回 true
            if (position == nums.length - 1) {
                return true;
            }
            // 当前位置能跳到的最远位置：当前位置+当前位置允许跳的最远距离之和与目标位置，两者中较小的那一个
            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            // 下一步位置的范围为：当前位置的下一步到当前位置能跳到的最远位置
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 优化后的回溯（Time Limit Exceeded）
     */
    private class OptimizedBacktracking {
        public boolean canJump(int[] nums) {
            return canJumpFromPosition(0, nums);
        }

        private boolean canJumpFromPosition(int position, int[] nums) {
            // 当前位置为目标位置，返回 true
            if (position == nums.length - 1) {
                return true;
            }
            // 当前位置能跳到的最远位置：当前位置+当前位置允许跳的最远距离之和与目标位置，两者中较小的那一个
            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            // 下一步位置的范围为：当前位置能跳到的最远位置到当前位置的下一步（反向）
            for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * dp 自顶向下（Time Limit Exceeded）
     * 与回溯思路类似，记录已经确定过无法通达的节点，减少重复计算
     */
    private class DPTopDown {
        // 1 可通达；-1 不可通达；0 未知
        int[] memo;

        public boolean canJump(int[] nums) {
            memo = new int[nums.length];
            memo[memo.length - 1] = 1;
            return canJumpFromPosition(0, nums);
        }

        private boolean canJumpFromPosition(int position, int[] nums) {
            // 已访问过的节点，根据 memo 标记的信息，直接返回
            if (memo[position] != 0) {
                return memo[position] == 1;
            }

            // 当前位置能跳到的最远位置：当前位置+当前位置允许跳的最远距离之和与目标位置，两者中较小的那一个
            int furthestJump = Math.min(position + nums[position], nums.length - 1);

            // 下一步位置的范围为：当前位置的下一步到当前位置能跳到的最远位置
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    memo[position] = 1;
                    return true;
                }
            }
            memo[position] = 0;
            return false;
        }
    }

    /**
     * dp 自底向上（Accepted 67 ms 38.9 MB）
     */
    private class DPBottomUp {
        // 1 可通达；-1 不可通达；0 未知
        int[] memo;

        public boolean canJump(int[] nums) {
            memo = new int[nums.length];
            memo[memo.length - 1] = 1;

            for (int i = nums.length - 2; i >= 0; i--) {
                int furthestJump = Math.min(i + nums[i], nums.length - 1);
                for (int j = i + 1; j <= furthestJump; j++) {
                    if (memo[j] == 1) {
                        memo[i] = 1;
                        break;
                    }
                }
            }
            return memo[0] == 1;
        }
    }

    /**
     * 贪心
     */
    private class Greedy {
        public boolean canJump(int[] nums) {
            // lastPos 设置为目标节点
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                // 当前节点加上当前节点所能到达的最远位置，大于等于能通达目标的位置，说明当前节点能到达目标位置，将 lastPos 更新为当前位置
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }

    /**
     * 贪心
     */
    private class Greedy2 {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            int max = 0;
            for (int i = 0; i <= max; i++) {
                max = Math.max(max, i + nums[i]);
                if (max >= len - 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
