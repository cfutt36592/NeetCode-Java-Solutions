class Solution {
    public boolean isHappy(int n) {
        int num = n;
        int sum = 0;
        Set<Integer> seen = new HashSet<>();

        while(!seen.contains(num)){
            seen.add(num);
            while(num != 0){
                sum += Math.pow(num % 10, 2);
                num /= 10;
            }
            if(sum == 1) return true;
            num = sum;
            sum = 0;
        }
        return false;
    }
}
