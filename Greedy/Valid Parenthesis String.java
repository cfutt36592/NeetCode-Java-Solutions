class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                leftMin++;
                leftMax++;
            }
            else if(s.charAt(i) == ')'){
                leftMin--;
                leftMax--;
            }
            else if(s.charAt(i) == '*'){
                leftMin--;
                leftMax++;
            }
            if(leftMin < 0) leftMin++;
            if(leftMax < 0) return false;
        }

        if(leftMin == 0) return true;
        return false;
    }
}
