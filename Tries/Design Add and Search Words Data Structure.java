class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new Node());
            }
            cur = cur.children.get(c);
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        return helper(word, root);
    }

    public boolean helper(String word, Node cur){
        int i = 0;
        for(char c : word.toCharArray()){
            if(c != '.'){
                if(!cur.children.containsKey(c)){
                    return false;
                }
                cur = cur.children.get(c);
            }
            else{
                for(Node temp : cur.children.values()){
                    if(temp != null && helper(word.substring(i + 1), temp)){
                        return true;
                    }
                }
                return false;
            }
            i++;
        }
        return cur.end;
    }
}

class Node {
    Map<Character, Node> children;
    boolean end;

    public Node(){
        children = new HashMap<>();
        end = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
