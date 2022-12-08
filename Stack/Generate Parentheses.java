class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        build(n, "", 0, 0);
        return res;
    }

    public void build(int n, String curr, int open, int closed){
        if(open == n && closed == n){
            res.add(curr);
            return;
        }
        if(open < n){
            build(n, curr + "(", open + 1, closed);
        }
        if(closed < open){
            build(n, curr + ")", open, closed + 1);
        }
    }
}
/*
Could also use stack as global to track:

List<String> res = new ArrayList<>();
Stack<Character> stack = new Stack<>();

    public List<String> generateParenthesis(int n) {
        build(n, "", 0, 0);
        return res;
    }

    public void build(int n, int open, int closed){
        if(open == n && closed == n){
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if(open < n){
            stack.push('(');
            build(n, open + 1, closed);
            stack.pop();
        }
        if(closed < open){
            stack.push(')');
            build(n, open, closed + 1);
            stack.pop();
        }
    }
*/
