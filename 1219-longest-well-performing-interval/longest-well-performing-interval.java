class Solution {
    public int longestWPI(int[] hours) {
        int[] prefix = new int[hours.length + 1];

        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;

        for (int i = 0; i < hours.length; i++) {
            prefix[i + 1] = prefix[i] + (hours[i] > 8 ? 1 : -1);
        }

        for (int i = 0; i < prefix.length; i++) {
            if (stack.isEmpty() ||
                prefix[i] < prefix[stack.peek()]) {
                stack.push(i);
            }
        }

        for (int i = prefix.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() &&
            prefix[i] > prefix[stack.peek()]) {
                int index = stack.pop();
                maxLen = Math.max(maxLen, i - index);
            }
        }
    return maxLen;
    }
}