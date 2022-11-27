class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.equals("")) {
            res.add(new ArrayList<>());
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i + 1)) {
                for (List<String> list : partition(s.substring(i + 1))) {
                    list.add(0, s.substring(0, i + 1));
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int n){
        for(int i = 0; i < n / 2; i++){
            if(s.charAt(i) != s.charAt(n - 1 - i)) return false;
        }
        return true;
    }
}

/*
solution almost working: 
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        check(s, new ArrayList<>(), res);
        return res;
    }

    public void check(String s, List<String> cur, List<List<String>> res){
        if(s.equals("")){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s, i + 1)){
                cur.add(s.substring(0, i + 1));
                check(s.substring(i + 1), cur, res);
                cur.remove(s.substring(0, i + 1));
            }
        }
        return;
    }

*/
