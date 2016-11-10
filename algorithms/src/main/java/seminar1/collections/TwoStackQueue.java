package seminar1.collections;

import java.util.Iterator;

/**
 * №5.2
 */
public class TwoStackQueue<Item> implements IQueue<Item> {

    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        for (int i = 5; i > 0; i--) {
            queue.enqueue(i);
        }
        System.out.println("Size: " + queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    private IStack<Item> stack1;
    private IStack<Item> stack2;

    public TwoStackQueue() {
        stack1 = new ArrayStack<Item>();
        stack2 = new ArrayStack<Item>();
    }

    @Override
    public void enqueue(Item item) {
        stack1.push(item);
    }

    @Override
    public Item dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }

    @Override
    public Iterator<Item> iterator() {
        /* TODO: implement it (optional) */
        return null;
    }

}
