public class LongestBalancedSubarray {


    public static int longestEqualZerosOnesNonRecursive(int[] nums) {

        int n = nums.length;


        int size = (2 * n) + 1;

        int[] firstIndex = new int[size];
        boolean[] visited = new boolean[size];

        int offset = n;


        firstIndex[offset] = -1;
        visited[offset] = true;

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                prefixSum = prefixSum - 1;
            } else {
                prefixSum = prefixSum + 1;
            }

            int position = prefixSum + offset;

            if (visited[position] == true) {

                int currentLength =
                        i - firstIndex[position];

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }

            } else {

                visited[position] = true;
                firstIndex[position] = i;
            }
        }

        return maxLength;
    }

    public static int longestEqualZerosOnesRecursive(int[] nums) {

        int n = nums.length;

        int size = (2 * n) + 1;

        int[] firstIndex = new int[size];
        boolean[] visited = new boolean[size];

        int offset = n;

        firstIndex[offset] = -1;
        visited[offset] = true;

        return solveRecursive(
                nums,
                0,
                0,
                0,
                firstIndex,
                visited,
                offset
        );
    }

    private static int solveRecursive(
            int[] nums,
            int index,
            int prefixSum,
            int maxLength,
            int[] firstIndex,
            boolean[] visited,
            int offset
    ) {

        if (index >= nums.length) {
            return maxLength;
        }

        if (nums[index] == 0) {
            prefixSum = prefixSum - 1;
        } else {
            prefixSum = prefixSum + 1;
        }

        int position = prefixSum + offset;

        if (visited[position] == true) {

            int currentLength =
                    index - firstIndex[position];

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }

        } else {

            visited[position] = true;
            firstIndex[position] = index;
        }

        return solveRecursive(
                nums,
                index + 1,
                prefixSum,
                maxLength,
                firstIndex,
                visited,
                offset
        );
    }


}