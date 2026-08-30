class Solution {
    public String fractionToDecimal(int num, int demon) {
        if (num == 0)
            return "0";
        
        StringBuilder res = new StringBuilder();
        if (num < 0 ^ demon < 0) {
            res.append("-");        
        }

        long dividend = Math.abs(Long.valueOf(num));
        long divisor = Math.abs(Long.valueOf(demon));

        res.append(dividend / divisor);

        long rem = dividend % divisor;
        if (rem == 0) {
            return res.toString();
        }

        res.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (rem != 0) {
            if (map.containsKey(rem)) {
                res.insert(map.get(rem), "(");
                res.append(")");
                break;
            }

            map.put(rem, res.length());
            rem *= 10;

            res.append(rem / divisor);
            rem %= divisor;
        }

        return res.toString();
    }
}

