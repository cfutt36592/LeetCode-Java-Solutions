class T {
  public String value;
  public int timestamp;
  public T(String value, int timestamp) {
    this.value = value;
    this.timestamp = timestamp;
  }
}
class TimeMap {
    
    private Map<String, List<T>> map;

    public TimeMap() {
        map = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new T(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<T> A = map.get(key);
        if (A == null)
            return "";
        
        int left = 0;
        int right = A.size();
        
        while(left<right){
            int mid = left + (right-left) / 2;
            
            if(A.get(mid).timestamp > timestamp)
                right = mid;
            else
                left = mid+1;
        }
        
        if(left == 0)
            return "";
        else
            return A.get(left-1).value;
    }
    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
