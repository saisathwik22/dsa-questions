//  Using Stack 

class Solution {
    public String removeSubstr(String s, String matchStr) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == matchStr.charAt(1) && !st.isEmpty() && st.peek() == matchStr.charAt(0)) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder temp = new StringBuilder();
        while(!st.isEmpty()) {
            temp.append(st.peek());
            st.pop();
        }
        temp.reverse();
        return temp.toString();
    }
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int score = 0;
        String maxStr, minStr;
        if(x > y) {
            maxStr = "ab";
            minStr = "ba";
        } else {
            maxStr = "ba";
            minStr = "ab";
        }

        String tempFirst = removeSubstr(s, maxStr);
        int L = tempFirst.length();
        int charRemoved = n - L;
        score = score + (charRemoved/2) * Math.max(x, y);

        String tempSecond = removeSubstr(tempFirst, minStr);
        charRemoved = L - tempSecond.length();
        score = score + (charRemoved/2) * Math.min(x, y);

        return score;
    }
}

// Without using Stack 
class Solution {
    public String removeSubstr(String s, String matchStr) {
       int i = 0; 
       StringBuilder sb = new StringBuilder(s);
       for(int j = 0; j < s.length(); j++) {
            sb.setCharAt(i, sb.charAt(j));
            i++;
            if(i >= 2 && sb.charAt(i-2) == matchStr.charAt(0) && sb.charAt(i-1) == matchStr.charAt(1)) {
                i = i - 2;
            }
        }
        sb.delete(i, s.length());
        return sb.toString();

    }
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int score = 0;
        String maxStr, minStr;
        if(x > y) {
            maxStr = "ab";
            minStr = "ba";
        } else {
            maxStr = "ba";
            minStr = "ab";
        }

        String tempFirst = removeSubstr(s, maxStr);
        int L = tempFirst.length();
        int charRemoved = n - L;
        score = score + (charRemoved/2) * Math.max(x, y);

        String tempSecond = removeSubstr(tempFirst, minStr);
        charRemoved = L - tempSecond.length();
        score = score + (charRemoved/2) * Math.min(x, y);

        return score;
    }
}
