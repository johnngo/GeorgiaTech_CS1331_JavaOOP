class Node<E> {
    //a variable named data
    public E data;
    //a variable named next
    public Node <E> next;
    //constructor, takes in two arguments exactly in the given order-data and next node and assigns it
    Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
    Node(E data) {
        this(data,null);
    }

    //methods//getters and setters for instance variables
    public E getData() {
        return data;
    }
    public Node<E> getNodeNext() {
        return next;
    }
    //setters for instance variables
    public void setData(E newData){
        data = newData;
    }
    public void setNodeNext(Node <E> newNext){
        next = newNext;
    }
}