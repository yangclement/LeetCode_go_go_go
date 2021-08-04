public class Node {
    public int key;
    public int value;
    public Node next;
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}


class LRUCache {
    //这道题是一道在线算法题，input是不确定的，是个data stream，需要设计一个数据结构
    //这种题目一般都是使用空间换取时间
    //1.使用java里面的linkedhashmap做，但是过于简单，面试官不一定允许
    //2.自己做一个hashmap，key是node的值，value是node的指针
    //分析一下2的做法，insert-> 只需要在linkedlist后面加入就好，0(1)
    //search->因为有value，所以直接在hashmap，里面找到相对应的node就好->O(1)
    //delete->同上，linkedlist主要是search费O(n), 现在有hashmap，找到只需要O(1), 删除也是O(1);
    //第一次做心得：炸了！！首先应该想想你要有什么操作，然后要有什么helper function，不能有多余的，不能有重复的
    //pop第一个，加入最后一个，存在的话把他踢到最后面
    public int capacity;
    public Node dummy;
    public Node tail;
    public Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        dummy = new Node(0, 0);
        tail = dummy;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node curr = map.get(key);
        kick(key);
        return tail.value;
    }
    
    public void put(int key, int value) {
        //因为是单向linkedlist，需要hashmap去找他的prev，所以hashmap存的是当前node的prev，如果是双向，可以就存当前node就好
        //如果存在
        if (get(key) != -1) {
            kick(key);
            //更新这个node的value
            tail.value = value;
            return;
        }
        //如果不存在
        Node newNode = new Node(key, value);
        pushBack(newNode);
        if (map.size() > capacity) {
            popFront();
        }
    }
    
    private void kick(int key) {
        //这个helper用来把存在的node踢到最后面
        //在hashmap里面先找到这个node的prev
        Node prev = map.get(key);
        
        //需要被删除的node
        Node curr = prev.next;
        
        //如果tail就是curr，直接return
        if (curr == tail) {
            return;
        }
        //先删除
        prev.next = curr.next;
        
        //curr的next的前一个变成prev
        map.put(curr.next.key, prev);
        //弄到最后
        curr.next = null;
        pushBack(curr);
    }
    
    private void pushBack(Node node) {
        tail.next = node;
        //这个node的hashmap到tail上
        map.put(node.key, tail);
        //改变尾部
        tail = tail.next;
        //增加capacity的工作留给call他的function处理
    }
    
    private void popFront() {
        //dummy的下一个永远是head
        Node head = dummy.next;
        dummy.next = head.next;
        //删除head在map里面的数据
        map.remove(head.key);
        //把head的下一个存到map里面，不需要担心是否null，hashmap里面允许null的key
        map.put(head.next.key, dummy);
        //减少capacity的工作留给call他的function处理
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */