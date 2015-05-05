package singlylinkedqueue;

/**
 *
 * @author gschroeder
 */
public class SinglyLinkedQueue<E> implements Queue<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int numElements;

    public SinglyLinkedQueue() {
        head = null;
        tail = null;
        numElements = 0;
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        if (numElements == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (numElements > 10) {
            return true;
        }
        return false;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return head.getElement();
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return tail.getElement();
    }

    @Override
    public void enqueue(E element) throws OverflowException {
        Node<E> node = new Node<E>(element);
        if (isFull()) {
            throw new OverflowException();
        }
        if (isEmpty()) {
            head = tail = node;
        }

        tail.setNext(node);
        tail = node;
        numElements++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E aux = head.getElement();
        head.setNext(head.getNext());
        numElements--;
        return aux;
    }

    public String toString() {
        String s = "";
        s += "[";
        if (!isEmpty()) {
            Node<E> p = head;
            do {
                s += p.getElement();
                if (p != tail) {
                    s += ", ";
                }
                p = p.getNext();
            } while (p != null);
        }
        s += "]";
        return s;
    }

}
