package leetcode.数据结构;

import java.util.ArrayList;

/**
 * <pre>
 *
 * </pre>
 *
 * @author <a href="https://github.com/Ken-Chy129">Ken-Chy129</a>
 * @since 2023/4/14 20:30
 */
public class Heap<E extends Comparable<E>> {
    
    private ArrayList<E> elements;
    
    public Heap() {
        elements = new ArrayList<>();
    }

    public boolean offer(E val) {
        int index = elements.size();
        elements.add(val);
        liftUp(index);
        return true;
    }
    
    private void liftUp(int index) {
        while (index != 0) {
            int parentIndex = (index - 1) >> 1;
            E parentElement = elements.get(parentIndex);
            E currentElement = elements.get(index);
            if (parentElement.compareTo(currentElement) < 0) {
                elements.set(parentIndex, currentElement);
                elements.set(index, parentElement);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    
    public int size() {
        return elements.size();
    }
    
    public E removeTop() {
        E top = elements.get(0);
        int size = elements.size();
        elements.set(0, elements.get(size - 1));
        elements.remove(size - 1);
        siftDown(0);
        return top;
    }

    private void siftDown(int index) {
        int leftIndex, rightIndex;
        while ((leftIndex = index * 2 + 1) < size()) {
            E currentElement = elements.get(index);
            E leftElement = elements.get(leftIndex);
            if ((rightIndex = leftIndex + 1) >= size()) {
                if (currentElement.compareTo(leftElement) < 0) {
                    elements.set(index, leftElement);
                    elements.set(leftIndex, currentElement);
                }
                break;
            }
            E rightElement = elements.get(rightIndex);
            if (leftElement.compareTo(rightElement) < 0) {
                elements.set(index, rightElement);
                elements.set(rightIndex, currentElement);
                index = rightIndex;
            } else {
                elements.set(index, leftElement);
                elements.set(leftIndex, currentElement);
                index = leftIndex;
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.offer(2);
        heap.offer(3);
        heap.offer(1);
        System.out.println(heap.removeTop());
        heap.offer(100);
        heap.offer(-12);
        heap.offer(80);
        heap.offer(122);
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
    }
}
