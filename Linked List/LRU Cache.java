class LRUCache {
    
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int ret = -1;
        Node node = map.get(key);
        if(node != null){
            ret = node.val;
            remove(node);
            add(node);
        }
        
        return ret;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){//update value
            remove(node);
            node.val = value;
            add(node);
        }
        else{//create node
            if(map.size() == cap){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            
            map.put(key, newNode);
            add(newNode);
        }
    }
    
    
    private void add(Node node){
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }
    
    private void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
