package linkedlist;
import java.util.Iterator;
import java.util.Comparator;
public class LinkedList<T> implements Iterable<T>{
    protected class Node<T>{
	private T data;
	private Node<T> next;
	private Node<T> prev;
	public void setNext(Node<T> n){
	    this.next = n;
	}
	public void setPrev(Node<T> n){
	    this.prev = n;
	}
	public T getData(){
	    return this.data;
	}
	public Node<T> getNext(){
	    return this.next;
	}
	public Node<T> getPrev(){
	    return this.prev;
	}
	public Node(T item){
	    this.data = item;
	    next = null;
	    prev = null;
	}
    }


    protected class LinkedListIterator implements Iterator<T> { 
	Node<T> curr; 
       
	public boolean hasNext(){ 
	    return curr != null; 
	} 
      
	public T next(){ 
	    T data = curr.getData(); 
	    curr = curr.getNext(); 
	    return data; 
	} 
      
	public LinkedListIterator(LinkedList<T> list){ 
	    curr = list.getRoot(); 
	} 
    
    } 



    private Node<T> root;
    private Node<T> tail;
    private int size;
    
    public boolean append(T item){
	if(root == null){
	    root = new Node<T>(item);
	    tail = root;
	}else{
	    Node<T> n = new Node<T>(item);
	    tail.setNext(n);
	    n.setPrev(tail);
	    tail = n;
	}
	this.size += 1;
	return true;
    }

    public T remove(int index){
	if(root == null){
	    return null;
	}else if(index == 0){
	    Node<T> curr = root;
	    root = curr.getNext();
	    if(root != null){
		root.setPrev(null);
	    }
	    this.size -= 1;
	    return curr.getData(); 
	}else if(index == this.size-1){
	    Node<T> curr = tail;
	    tail = tail.getPrev();
	    if(tail != null){
	        tail.setNext(null);
	    }
	    this.size -= 1;
	    return curr.getData();
	}else{
	    Node<T> curr = root.getNext(); 
	    int i = 1;
	    while(i < index && curr.getNext() != null){
		curr = curr.getNext();
		i += 1;
	    }
	    if(i == index && curr != null){
		if(curr.getPrev() != null){
		    curr.getPrev().setNext(curr.getNext());
		}
	        if(curr.getNext() != null){
		    curr.getNext().setPrev(curr.getPrev());
		}
		this.size -= 1;
		return curr.getData();
	    }
	}
	return null;
    }

    public int size(){
	return this.size;
    }

    public T get(int index){
	if(root == null){
	    return null;
	}else{
	    Node<T> curr = root; 
	    int i = 0;
	    while(i < index && curr.getNext() != null){
		curr = curr.getNext();
		i += 1;
	    }
	    if(i == index && curr != null){
		return curr.getData();
	    }
	}
	return null;
    }

    public T getFirst(){
	return root.getData();
    }

    protected Node<T> getRoot(){
	return root;
    }

    
    public Iterator<T> iterator(){ 
        return new LinkedListIterator(this); 
    } 

    public void swap(Node<T> a, Node<T> b){
	if(a.getPrev() != null){
	    a.getPrev().setNext(b);
	}
	a.setNext(b.getNext());
	if(b.getNext() != null){
	    b.getNext().setPrev(a);
	}
	b.setNext(a);
	b.setPrev(a.getPrev());
	a.setPrev(b);
	if(a == root){
	    root = b;
	}else if(a == tail){
	    tail = b;
	}
    }

    public void sort(Comparator<T> c){
	if(root == null){
	    return;
	}else if(root.getNext() == null){
	    return;
	}else{
	    Node<T> curr;
	    boolean swapped;
	    do{
		curr = root;
		swapped = false;
		while(curr.getNext() != null){
		    if(c.compare(curr.getData(), curr.getNext().getData()) > 0){
			swap(curr, curr.getNext());
			swapped = true;
		    }else{
			curr = curr.getNext();
		    }
		}
	    }while(swapped);
	}
    }
    
    public LinkedList(){
	this.root = null;
	this.tail = null;
	this.size = 0;
    }

    public LinkedList(LinkedList<T> l){
	Node<T> curr = l.getRoot();
        while(curr != null){
	    append(curr.getData());
	    curr = curr.getNext();
	}
    }
}
