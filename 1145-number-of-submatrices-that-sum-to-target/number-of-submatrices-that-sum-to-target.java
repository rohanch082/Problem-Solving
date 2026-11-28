class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        
        for(int startRow = 0; startRow < rows; startRow++){
            int[] compressed = new int[cols];
            for(int endRow = startRow; endRow < rows; endRow++){
                for(int col = 0; col < cols; col++){
                    compressed[col] += matrix[endRow][col];
                }
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                int prefixSum = 0;
                for(int col = 0; col < cols; col++){
                    prefixSum += compressed[col];
                    count += map.getOrDefault(prefixSum - target, 0);
                    map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
                }
            }
        }
        return count;
    }
}