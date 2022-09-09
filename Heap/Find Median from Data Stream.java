class MedianFinder {
    PriorityQueue<Integer> smallHeap = null;
    PriorityQueue<Integer> largeHeap = null;

    public MedianFinder() {
        largeHeap = new PriorityQueue<>(); //min heap for large half of list
        smallHeap = new PriorityQueue<>(Comparator.reverseOrder()); //max heap for small half of list
    }
    
    public void addNum(int num) {
        largeHeap.offer(num);
        smallHeap.offer(largeHeap.poll());
        
        if(largeHeap.size() < smallHeap.size()){
            largeHeap.offer(smallHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() < largeHeap.size()){
            return largeHeap.peek();
        }
        else{
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }
    }
}
