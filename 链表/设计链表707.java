package leetcode.链表;

/**
 * <pre>
 * <p>链表的设计：单链表和双链表</p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2023/1/5 11:29
 */
// 单链表
class MyLinkedList {
    
    private int size;
    
    private MyListNode head;

    public MyLinkedList() {
        size = 0;
        head = new MyListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        MyListNode p = head;
        for (int i=0; i<=index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        MyListNode p = head;
        for (int i=0; i<index; i++) {
            p = p.next;
        }
        MyListNode newNode = new MyListNode(val);
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        MyListNode p = head;
        for (int i=0; i<index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        size--;
    }
}

class MyListNode {
    
    int val;
    
    MyListNode next;

    public MyListNode() {
    }

    public MyListNode(int val) {
        this.val = val;
    }

    public MyListNode(int val, MyListNode next) {
        this.val = val;
        this.next = next;
    }
    
}

// 双链表
class BiLinkedList {

    private int size;

    private BiListNode head;
    
    private BiListNode tail;

    public BiLinkedList() {
        size = 0;
        head = new BiListNode(0);
        tail = new BiListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        BiListNode p;
        if (index < size/2) {
            p = head;
            for (int i=0; i<=index; i++) {
                p = p.next;
            }
        } else {
            p = tail;
            for (int i=0; i<size-index; i++) {
                p = p.prev;
            }
        }
        return p.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        BiListNode p;
        if (index < size/2) {
            p = head;
            for (int i=0; i<index; i++) {
                p = p.next;
            }
        } else {
            p = tail;
            for (int i=0; i<=size-index; i++) {
                p = p.prev;
            }
        }
        BiListNode newNode = new BiListNode(val);
        newNode.next = p.next;
        newNode.prev = p;
        p.next.prev = newNode;
        p.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        BiListNode p;
        if (index < size/2) {
            p = head;
            for (int i=0; i<index; i++) {
                p = p.next;
            }
        } else {
            p = tail;
            for (int i=0; i<=size-index; i++) {
                p = p.prev;
            }
        }
        p.next = p.next.next;
        p.next.prev = p;
        size--;
    }
}

class BiListNode {

    int val;

    BiListNode next;
    
    BiListNode prev;

    public BiListNode() {
    }

    public BiListNode(int val) {
        this.val = val;
    }
    
}
