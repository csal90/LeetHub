class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] p : pieces) {
            map.put(p[0], p);
        }
        
        int i = 0;
        while (i < arr.length) {
            // find target piece
            if (!map.containsKey(arr[i])) {
                return false;
            }
            // check target piece
            int[] targetPiece = map.get(arr[i]);
            for (int x : targetPiece) {
                if (x != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
