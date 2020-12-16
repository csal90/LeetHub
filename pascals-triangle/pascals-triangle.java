class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*
            1. Create a result array
            2. Create a 1D array which will be the rows we will append to result
            3. Start for loop i <-- 0 to numRows
            4. Immedietly add (1) at index 0 since it will always be there
            5. Start nested for loop j <-- 1 to row - 1
            6. We start at 1 because i started at 0 
            7. We go up until row.size() - 1 because we don't need the last element
            8. Follow up ^ because we only care about the middle values
            9. At each iteration we will set the jth row to j + j + 1
            10. Add the row to the res array
            11. Return the res array
        */
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = row.size() - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
            res.add(new ArrayList(row));
        }
        return res;
    }
}
