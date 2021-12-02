import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;

//this class should implement the provided List<T> interface
public class LinkedList<T> implements List<T> {
// a variable name head
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public Node<T> getHead() {
        return this.head;
    }
    public Node<T> getTail(){
        return this. tail;
    }
    public int getSize(){
        return this.size;
    }

    public void addAtIndex(T data, int index) throws IllegalArgumentException{
        if(index < 0) {
            throw new IndexOutOfBoundsException(" the index is less than 0");
        } else if(index > size) {
            throw new IndexOutOfBoundsException(" the index is greater " + "than size");
        } else if( data == null){
            throw new IllegalArgumentException(" the data is null "+ "(does not refer to any value).");
        }
    }

    public T getAtIndex(int index) throws IllegalArgumentException{
        Node <T> currentNode = this.head;
        Node <T> previousNode = null;
        T returnData = null;
        if(index < 0 || index > this.size - 1){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if(this.head == null){
            return null;
        } else {
            int count = 0;
            while (currentNode != null){
                count = count + 1;
                previousNode = currentNode;
                currentNode = currentNode.getNodeNext();
                if(index == count) {
                    if(currentNode == this.head) {
                        returnData = this.head.getData();
                    } else if(currentNode == this.tail) {
                        returnData = this.tail.getData();
                    }else {
                        returnData = (T) currentNode.getData();
                    }
                }
            }
        }
        return returnData;
    }

    public T removeAtIndex(int index) throws IllegalArgumentException{
        T returnData = null;
        Node <T> currentNode = this.head;
        Node <T> previousNode = new Node <T> (null, this.head);
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        } 
        if (this.head == null) {
            return null;
        }
        int count = 0;
        while (currentNode != null) {
            count = count + 1;
            previousNode = currentNode;
            currentNode = currentNode.getNodeNext();
            if (index == count) {
                if (currentNode == this.head) {
                    returnData = this.head.getData();
                    previousNode.setNodeNext(currentNode.getNodeNext());
                    this.head = previousNode;
                } else if (currentNode == this.tail) {
                    returnData = (T) currentNode.getData();
                    previousNode.setNodeNext(null);
                    currentNode.setNodeNext(null);
                    this.tail = previousNode;
                } else {
                    returnData = (T) currentNode.getData();
                    previousNode.setNodeNext(currentNode.getNodeNext());
                    currentNode.setNodeNext(null);
                }
                this.size --;
            }
        }
        return returnData;
    }

    public T remove(T data) throws IllegalArgumentException, NoSuchElementException {
        T returnData = null;
        Node <T> currentNode = this.head;
        System.out.println("the head is" + this.head.getData());
        Node <T> previousNode = new Node <T> (null, this.head);
        if (data == null || this.head == null) {
            returnData = data;
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        while (currentNode != null) {
            System.out.println("breakpoint 1");
            System.out.println(data);
            System.out.println (data = this.head.getData());
            previousNode = currentNode;
            currentNode = currentNode.getNodeNext();
            if (currentNode.getData() == data) {
                System.out.println("match!");
                returnData = (T) currentNode.getData();
                if (currentNode == this.head){
                    previousNode.setNodeNext(currentNode.getNodeNext());
                    this.head = previousNode;
                } else if (currentNode == this.tail) {
                    previousNode.setNodeNext(null);
                    currentNode.setNodeNext(null);
                    this.tail = previousNode;
                } else {
                    System.out.println("remove in the middle");
                    previousNode.setNodeNext(currentNode.getNodeNext());
                    currentNode.setNodeNext(null);
                }
                this.size --;
            } else {
                if (currentNode == this.tail) {
                    returnData = data;
                    throw new NoSuchElementException("The data is not present in the list.");
                } 
            }
        }
        return returnData;
    }
    public void clear() {
        this.head=null;
        this.size=0;
    }
    public boolean isEmpty() {
        return( this.size==0);
    }

    public int size(){
        return this.size;
    }
}




