public class Node<E>
{
    //private fields
    private Node previous;
    private Node next;
    private E data;

    /**
     * Constructor for a new Node, which will point to itself
     * @param The element the data field will contain
     */
    public Node(E element)
    {
        data = element;
        next = this;
        previous = this;
    }
    
    /**
     * Constructor for a new Node with more specifications
     * @param The element the data field will contain
     * @param The previous Node
     * @param The nest Node
     */
    public Node(E element, Node previous, Node next) {
        data = element;
        this.previous = previous;
        this.next = next;
    }
    
    /**
     * Returns the data field
     */
    public E getData() {
        return data;
    }
    
    /**
     * Returns the next Node
     */
    public Node getNext() {
        return next;
    }
    
    /**
     * Returns the previous Node
     */
    public Node getPrevious() {
        return previous;
    }
    
    
    /**
     * Sets the next Node
     * @param What Node to set next to
     */
    public void setNext(Node node) {
        next = node;
    }
    
    /**
     * Sets the previous Node
     * @param What Node to set previous to
     */
    public void setPrevious(Node node) {
        previous = node;
    }
    
    /**
     * Sets the data field
     * @param What element to set data to
     */
    public void setData(E element) {
        data = element;
    }
}
