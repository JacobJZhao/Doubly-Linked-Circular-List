public interface IList<E>
{
    boolean add(int index, E element);
    boolean addFirst(E element);
    boolean addLast(E element);
    
    void delete(int index);
    void deleteFirst();
    void deleteLast();
    
    int size();
    void clear();
    
    boolean contains(E element);
    
    E get(int index);
    E getFirst();
    E getLast();
    
    void set(int index, E element);
}
