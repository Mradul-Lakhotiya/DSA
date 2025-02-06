class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        List<Integer> product = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                product.add(nums[i] * nums[j]);
            }
        }

        Collections.sort(product);

        int lastProduct = -1;
        int count = 0;

        for (int i = 0; i < product.size(); i++) {
            if (product.get(i) == lastProduct) {
                count++;
            }
            else {
                int noOfPair = ((count - 1) * count) / 2;

                ans += 8 * noOfPair;

                lastProduct = product.get(i);

                count = 1;
            }
        }

        int noOfPair = ((count - 1) * count) / 2;

        ans += 8 * noOfPair;

        return ans;
    }; 
}