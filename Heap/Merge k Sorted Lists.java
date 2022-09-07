/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);
        
        for(int i = 0; i < lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                heap.add(temp.val);
                temp = temp.next;
            }
        }
        
        if(heap.isEmpty()) return null;
        
        ListNode start = new ListNode(heap.poll());
        ListNode list = start;
        
        while(!heap.isEmpty()){
            ListNode temp = new ListNode(heap.poll());
            list.next = temp;
            list = list.next;
        }
        
        return start;
    }
}
