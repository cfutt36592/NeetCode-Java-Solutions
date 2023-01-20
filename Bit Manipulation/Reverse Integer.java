class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        x = Math.abs(x);
        int num = 0;
        
        while(x > 0){
            if(Integer.MAX_VALUE / 10 < num) return 0;

            num = (num * 10) + (x % 10);
            x /= 10;
        }
        if(isNeg) return num * -1;
        else return num;
    }
}
