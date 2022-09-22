class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for(char c: word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new Node());
            } 
            cur = cur.children.get(c);
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for(char c: word.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            } 
            cur = cur.children.get(c);
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char c: prefix.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            } 
            cur = cur.children.get(c);
        }
        return true;
    }
}

class Node {
    Map<Character, Node> children;
    Boolean end;
    
    public Node() {
        children = new HashMap<>();
        end = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
