public class LinkedListADT<T> implements List<T>{
private Node<T> head;
private Node<T> current;

public LinkedListADT(){
    head=current=null;
}
    @Override
    public boolean empty() {
        
        return head==null;
    }

    @Override
    public void findfirst() {
        current=head;
        
    }

    @Override
    public void findnext() {
        current=current.next;
        
    }

    @Override
    public boolean full() {
        
        return false;
    }

    @Override
    public void insert(T e) 
    {
        Node<T> temp =new Node<T>(e);
      if(empty())
      head=current=temp;
      else{ 
        if(((Contact)temp.data).compareTo((Contact)head.data)<0)
        {
            temp.next=head;
            head=temp;
        }
        else{
            Node<T> p = head;
            Node<T> q =null;
            while(p != null &&(((Contact)p.data).compareTo(((Contact)temp.data))<=0  ) )
            {
               q=p;
               p=p.next;

            }
            q.next=temp;
            temp.next=p;


        }



      }

        
    }

    @Override
    public boolean last() {
        
        return current.next==null;
    }

    @Override
    public void remove() {   //remove contact  current pointing to
        if(current == head)
        {
            current = current.next;
            head=head.next;
        }
        else{
            Node<T> temp = head;
            while (temp.next != current)
            temp =temp.next;

            temp.next=current.next;
            if(current.next!= null)
            current=current.next;
            else
            current=head;



        }

        
        
    }

    @Override
    public T retrive() { 
        return current.data;
    }

    @Override
    public void update(T data) { 
        current.data=data;
       
        
    }

    public boolean search(T d){
        if(head==null) // if empty
        return false;

        
        Node<T> temp=head;
        while(temp!= null)
        {
            if(temp.data.equals(d)) // how it will comapare objects??
            return true;
            else
                current=current.next;
        }
        return false;

    }



    
}
