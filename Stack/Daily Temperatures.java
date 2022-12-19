class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int day = 0; day < temperatures.length; day++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[day]){
                int prevDay = stack.pop();
                ret[prevDay] = day - prevDay;
            }
            stack.add(day);
        }
        
        return ret;
    }
}
