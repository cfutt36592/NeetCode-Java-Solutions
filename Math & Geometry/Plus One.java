class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        
        for(int i = len - 1; i >= 0; i--){
            if(carry == 1){
                digits[i]++;
                carry = 0;
            } 
            if(digits[i] == 10){
                digits[i] = 0;
                carry = 1;
            } 
        }
        if(carry == 0) return digits;

        int[] arr = new int[len + 1];
        arr[0] = 1;
        for(int i = 0; i < len; i++){
            arr[i + 1] = digits[i];
        }
        return arr;
    }
}
