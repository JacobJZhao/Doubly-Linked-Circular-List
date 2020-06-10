public class DLCList<E> implements IList<E>
{
    //private fields
    private Node start;
    private int size;
    
    /**
     * Constructor
     */
    public DLCList() {
        start = null;
        size = 0;
    }
    
    /**
     * Adds E element at specified index in the list
     * Returns a boolean true, signifys success
     * @param Index at which to add
     * @param Element to add
     */
    public boolean add(int index, E element) { 
        if(index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (start == null) {
            start = new Node<E>(element);
            size += 1;
        }
        
        else{
            Node priorNode = start;
            Node afterNode = start;
        
            if(index == 0) {
                addFirst(element);
            }
            else if(index == size) {
                addLast(element);
            }
            else{
                for(int i = 0; i < index; i += 1) {
                    afterNode = afterNode.getNext();
                }
                priorNode = afterNode.getPrevious();
                
                Node node = new Node<E>(element, priorNode, afterNode);
                priorNode.setNext(node);
                afterNode.setPrevious(node);
                
                size += 1;
            }
        }
        return true;
    }
    
    /**
     * Adds an E element to the front of the list
     * Returns a boolean true, signifys success
     * @param Element to add to front
     */
    public boolean addFirst(E element) {
        if (start == null) {
            start = new Node<E>(element);
        }
        else {
            Node node = new Node<E>(element, start.getPrevious(), start);
            start.getPrevious().setNext(node);
            start.setPrevious(node);
            start = node;
        }
        
        size += 1;
        return true;
    }
    
    /**
     * Adds an E element to the end of the list
     * Returns a boolean true, signifys success
     * @param Element to add to end
     */
    public boolean addLast(E element) { 
        if (start == null) {
            start = new Node<E>(element);
        }
        else {
            Node node = new Node<E>(element, start.getPrevious(), start);
            start.getPrevious().setNext(node);
            start.setPrevious(node);
        }
        
        size += 1;
        return true;
    }
    
    /**
     * Deletes the element at the index specified from the list
     * @param Index at which to delete
     */
    public void delete(int index) { 
        Node temp = null;
        boolean alreadyChangedSize = false;
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else if(index == 0) {
            deleteFirst();
            alreadyChangedSize = true;
        }
        else if(index == size - 1) {
            deleteLast();
            alreadyChangedSize = true;
        }
        else if(index < (size - 1)/2) {
            temp = start;
            for(int i = 0; i < index; i += 1) {
                temp = temp.getNext();
            }
            Node temp2 = temp;
            temp.getPrevious().setNext(temp2.getNext());
            temp.getNext().setPrevious(temp2.getPrevious());
            }
        else {
            temp = start.getPrevious();
            for(int i = size - 1; i > index; i -= 1) {
                temp = temp.getPrevious();
            }
            Node temp2 = temp;
            temp.getPrevious().setNext(temp2.getNext());
            temp.getNext().setPrevious(temp2.getPrevious());
        }
        
        if(!alreadyChangedSize) {
            size -= 1;
        }
    }
    
    /**
     * Deletes the first element of the list
     */
    public void deleteFirst() { 
        start = start.getNext();
        size -= 1;
    }
    
    /**
     * Deletes the last element of the list
     */
    public void deleteLast() { 
        start.setPrevious(start.getPrevious().getPrevious());
        size -= 1;
    }
    
    /**
     * Returns the size of the list
     */
    public int size() { 
        return size;
    }
    
    /**
     * Clears the entire list, effecitvely re-initializing
     */
    public void clear() { 
        start = null;
        size = 0;
    }
    
    /**
     * Tests to see if the list contains the specified element
     * @param Element to check for
     */
    public boolean contains(E element) { 
        boolean result = false;
        
        Node temp = start;
        for(int i = 0; i < size; i += 1) {
            if(!result) {
                if(temp.getData().equals(element)) {
                    result = true;
                }
                temp = temp.getNext();
            }
        }
        
        return result;
    }
    
    /**
     * Returns the element at the specified index
     * @param Index at which to retrieve element, list starting at zero
     */
    public E get(int index) { 
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else if(index == 0) {
            return getFirst();
        }
        else if(index == size - 1) {
            return getLast();
        }
        else {
            if(index < (size - 1)/2) {
                Node temp = start;
                for(int i = 0; i < index; i += 1) {
                    temp = temp.getNext();
                }
                return (E)temp.getData();
            }
            else {
                Node temp = start.getPrevious();
                for(int i = size - 1; i > index; i -= 1) {
                    temp = temp.getPrevious();
                }
                return (E)temp.getData();
            }
        }
    }
    
    /**
     * Returns the first element of the list
     */
    public E getFirst() { 
        return (E)start.getData();
    }
    
    /**
     * Returns the last element of the list
     */
    public E getLast() { 
        return (E)start.getPrevious().getData();
    }
    
    /**
     * Sets the datapoint at the specified index to the specified element
     * @param Index at which to replace
     * @param Element to put in place
     */
    public void set(int i, E element) {
        delete(i);
        add(i, element);
    }
    
    /**
     * toString method
     * [element1], [element2], ... [elementn]
     */
    public String toString() {
        String returnString = "";
        Node temp = start;
        for(int i = 0; i < size; i += 1) {
            returnString = returnString + "[";
            returnString = returnString + temp.getData().toString();
            if(i != size - 1) {
                returnString = returnString + "], ";
            }
            else {
                returnString = returnString + "]";
            }
            
            temp = temp.getNext();
        }
        return returnString;
    }
}
