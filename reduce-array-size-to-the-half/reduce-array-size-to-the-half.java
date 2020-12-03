class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        // compute the frequency for each number
        for (int i = 0; i < arr.length; i++) {
            if (freq.containsKey(arr[i])) {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            } else {
                freq.put(arr[i], 1);
            }
        }
        
        // reverse sort a list of the map values
        List<Integer> counts = new ArrayList<>(freq.values());
        Collections.sort(counts);
        Collections.reverse(counts);
        
        // Remove all the numbers until at least half are removed
        int removedSoFar = 0;
        int setSize = 0;
        for (int N: counts) {
            removedSoFar += N;
            setSize += 1;
            if (removedSoFar >= arr.length / 2) {
                break;
            }
        }
        return setSize;
    }
}
