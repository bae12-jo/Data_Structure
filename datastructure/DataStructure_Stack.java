// https://www.youtube.com/watch?v=whVUYv0Leg0

import java.util.EmptyStackException;

/* stack object class */
class Stack<T>{ 

  /* node object class */
  class Node<T>{    
    private T data;
    private Node<T> next;
    
    /* constructor */
    public Node(T data){ 
      this.data = data;
    }
  }

  /* member variables */
  private Node<T> top;

  /* method - pop, push, peek, isEmpty */
  public T pop(){
    if(top ==null){
      throw new EmptyStackException();
    }

    T item = top.data;  
    top = top.next;     
    return item;       
  }

  public void push(T item){
    Node<T> t = new Node<T>(item);  
    t.next = top;                   
    top = t;                       
  }

  public T peek(){
    if(top == null){
      throw new EmptyStackException();
    }

    return top.data; 
  }
 
  public boolean isEmpty(){
    return top == null; 
  }
}

public class DataStructure_Stack { 
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.peek());
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
  }
}
