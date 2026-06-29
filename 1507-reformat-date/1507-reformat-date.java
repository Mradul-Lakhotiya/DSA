import java.util.*;

class Solution {
    public String reformatDate(String date) {
        HashMap<String, String> map = new HashMap<>();

        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");

        String[] parts = date.split(" ");

        String day = parts[0];
        String month = map.get(parts[1]);
        String year = parts[2];

        day = day.substring(0, day.length() - 2);

        if (day.length() == 1) {
            day = "0" + day;
        }

        return year + "-" + month + "-" + day;
    }
}