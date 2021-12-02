class Node<E> {
    public E data;
    public Node <E> next;
    Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
    Node(E data) {
        this(data,null);
    }
    public E getData() {
        return data;
    }
    public Node<E> getNodeNext() {
        return next;
    }
    public void setData(E newData){
        data = newData;
    }
    public void setNodeNext(Node <E> newNext){
        next = newNext;
    }
}