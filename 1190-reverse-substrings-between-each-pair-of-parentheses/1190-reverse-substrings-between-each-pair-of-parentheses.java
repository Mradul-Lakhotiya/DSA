class Solution {
    public String reverseParentheses(String s) {
        char[] ch = s.toCharArray();

        while (true) {
            int j = indexOf(ch, ')');
            if (j == -1) {
                break;
            }

            int i = findNearestOpen(ch, j);

            ch[i] = '/';
            ch[j] = '/';

            reverseRange(ch, i, j);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (c != '/') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }

    public static int indexOf(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int findNearestOpen(char[] array, int j) {
        for (int i = j - 1; i >= 0; i--) {
            if (array[i] == '(') return i;
        }
        return -1;
    }

    public static void reverseRange(char[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] == '(' || arr[i] == ')') {
                i++;
            } 
            else if (arr[j] == '(' || arr[j] == ')') {
                j--;
            } 
            else {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }
}
