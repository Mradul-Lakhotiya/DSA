class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> factors = primeFactors(nums[i]);

            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }


        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int i = q.poll();

                if (i == n - 1) {
                    return steps;
                }

                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }


                if (isPrime(nums[i])) {
                    int p = nums[i];

                    if (map.containsKey(p)) {
                        for (int idx : map.get(p)) {
                            if (!vis[idx]) {
                                vis[idx] = true;
                                q.offer(idx);
                            }
                        }

                        map.remove(p);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {
        if (x < 2)  {
            return false;
        }

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> primeFactors(int x) {
        List<Integer> res = new ArrayList<>();

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                if (isPrime(i)) {
                    res.add(i);
                }

                while (x % i == 0) {
                    x /= i;
                }
            }
        }

        if (x > 1) {
            res.add(x);
        }

        return res;
    }
}