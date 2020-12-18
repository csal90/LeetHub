class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbs = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minAbs = Math.min(arr[i] - arr[i-1], minAbs);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[i-1]) == minAbs) {
                res.add(new ArrayList<Integer>(List.of(arr[i - 1], arr[i])));
            }
        }
        return res;
    }
}
