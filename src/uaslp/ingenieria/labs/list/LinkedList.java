package uaslp.ingenieria.labs.list;

import static uaslp.ingenieria.labs.list.Position.AFTER;
import static uaslp.ingenieria.labs.list.Position.BEFORE;

/**
 * Lista doblemente ligada
 */
public class LinkedList<G> implements List<G> {

    private static class Node<T>{
        private final T data;
        private Node<T> previous;
        private Node<T> next;

        Node(T data){
            this.data = data;
        }
    }

    private Node<G> head;
    private Node<G> tail;
    private int size;

    public LinkedList() {
        listsCount ++;
    }

    private static int listsCount = 0;

    public static int getListsCount(){
        return listsCount;
    }


    public class ForwardIterator implements Iterator<G> {
        private Node<G> currentNode;

        public ForwardIterator() {
            this.currentNode = head;
        }

        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.data;

            currentNode = currentNode.next;

            return data;
        }

        Node<G> getCurrentNode() {  // modificador de acceso se llama -> package-private
            return currentNode;
        }
    }

    public class ReverseIterator implements Iterator<G> {

        private Node<G> currentNode;

        public ReverseIterator() {
            this.currentNode = tail;
        }


        public boolean hasNext(){
            return currentNode != null;
        }

        public G next(){
            G data = currentNode.data;

            currentNode = currentNode.previous;

            return data;
        }
    }

    /**
     * Inserts data at the end of the list
     *
     * @param data Data to be inserted
     */
    @Override
    public void add(G data) {
        Node<G> node = new Node<>(data);

        node.previous = tail;

        if (tail != null) {
            tail.next = node;
        }

        if (head == null) {
            head = node;
        }

        tail = node;
        size++;
    }

    /**
     * @param index 0-index
     * @return data in index
     */
    @Override
    public G get(int index) {
        Node<G> currentNode = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode.data;
    }

    @Override
    public void delete(int index) throws MyIndexOutOfBoundsException {
        Node<G> currentNode = head;
        int currentIndex = 0;

        if (index < 0 || index >= size) {
            throw new MyIndexOutOfBoundsException();
        }

        size--;

        if (size == 0) {
            head = null;
            tail = null;
        }

        if (index == 0 && size != 0) {
            head = head.next;
            head.previous = null;
        }

        if (index == size && size != 0) {
            tail = tail.previous;
            tail.next = null;
        }


        if (index > 0 && index < size) {
            while (currentIndex < index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }

    }

    @Override
    public Iterator<G> getIterator() {
        return new ForwardIterator();
    }

    @Override
    public void insert(G data, Position position, Iterator<G> it) throws MyIndexOutOfBoundsException {

        Node<G> newNode = new Node<>(data);
        Node<G> currentNode =((ForwardIterator)it).getCurrentNode();

        if (position == AFTER) {
            newNode.next = currentNode.next;
            newNode.previous = currentNode;
            currentNode.next = newNode;
            if (newNode.next != null) {
                newNode.next.previous = newNode;
            } else {
                tail = newNode;
            }
            size++;
        } else if (position == BEFORE) {
            newNode.previous = currentNode.previous;
            newNode.next = currentNode;
            currentNode.previous = newNode;
            if(newNode.previous == null) {
                head = newNode;
            }
            size++;
        } else {
            throw new MyIndexOutOfBoundsException();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public ReverseIterator getReverseIterator() {
        return new ReverseIterator();
    }
}