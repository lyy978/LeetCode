
public class LRUCache {
    /**
     * 面试题 16.25. LRU 缓存
     */
    int capacity;
    int size = 0;
    Node head;
    Node tail;
    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    //双向链表，伪头部和伪尾部
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public void put(int key,int value){
        Node node = new Node(key,value);
        if (getNode(node)!=null){
            delete(getNode(node));
            addFirst(node);
            return;
        }
        addFirst(node);

        size++;
        if (size>capacity){
//            System.out.println("c:"+capacity);
//            System.out.println("s:"+size);
//            System.out.println(tail.pre.key);
            delete(tail.pre);
        }
    }

    public int get(int key){
        if (size<=0)
            return -1;
        Node p = head.next;
        System.out.println("get:"+key);
        while (p!=null){
           if (p.key == key){
               //删除p节点
               delete(p);
//               print();
               //将p添加到hi头节点
               addFirst(p);
//               print();
               return p.value;
           }
           p = p.next;
        }
        return -1;
    }

    public Node getNode(Node node){
        Node p = head.next;
        while (p!=null){
            if (p.key == node.key){
               return p;
            }
            p = p.next;
        }
        return null;
    }

    public void addFirst(Node node){
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    public void delete(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void print(){
        Node p = head.next;
        while (p!=null&&p.key!=0){
            System.out.print(p.value+"->");
            p = p.next;
        }
        System.out.println();
    }
}
