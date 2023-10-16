public interface List<T> {
    public void findfirst();
    public void findnext();
    public T retrive();
    public void update(T e);
    public void insert(T e);
    public void remove();
    public boolean full();
    public boolean empty();
    public boolean last();

    
}
