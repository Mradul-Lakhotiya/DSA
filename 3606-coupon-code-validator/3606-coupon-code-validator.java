import java.util.*;

class Coupon implements Comparable<Coupon> {
    String code;
    String businessLine;

    public static final Map<String, Integer> order = Map.of(
        "electronics", 0,
        "grocery", 1,
        "pharmacy", 2,
        "restaurant", 3
    );

    Coupon(String code, String businessLine) {
        this.code = code;
        this.businessLine = businessLine;
    }

    String getCode() { return code; }

    @Override
    public int compareTo(Coupon other) {
        int cmp = order.get(this.businessLine) - order.get(other.businessLine);
        if (cmp != 0) return cmp;
        return this.code.compareTo(other.code);
    }
}

class Solution {

    public List<String> validateCoupons(String[] code,
                                        String[] businessLine,
                                        boolean[] isActive) {

        List<Coupon> coupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;

            if (code[i] == null || code[i].isEmpty()) continue;

            if (!code[i].matches("[A-Za-z0-9_]+")) continue;

            if (!Coupon.order.containsKey(businessLine[i])) continue;

            coupons.add(new Coupon(code[i], businessLine[i]));
        }

        Collections.sort(coupons);

        List<String> result = new ArrayList<>();
        for (Coupon c : coupons) {
            result.add(c.getCode());
        }

        return result;
    }
}
