import java.io.*;
import java.util.*;
public class MyLinkedList<E>{

  private class Node{

    private E data;
    private Node next,prev;
    public Node(E data, Node next, Node prev){
      this.data = data;
      this.next = next;
      this.prev = prev;
    }

    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }
    public void setNext(Node other){
      next = other;
    }
    public void setPrev(Node other){
      prev = other;
    }
    public E getData(){
      return data;
    }
    public E setData(E i){
      E output = getData();
      data = i;
      return output;
    }
    public String toString(){
      String output = "" + data;
      return output;
    }
    public boolean hasNext(){
      return next() != null;
    }
  }

  private int size;
  private Node start,end;

  public static void main(String[] args) {
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    test.add(2);
    test.add(5);
    test.add(7);
    System.out.println("add(2) and add(5) and add(7) performed...");
    System.out.println("Size: " + test.size());
    System.out.println("test: " + test);
    MyLinkedList<Integer> test2 = new MyLinkedList<Integer>();
    System.out.println("test2: 7" + test2);
    test2.add(7);
    test2.extend(test);
    System.out.println("test2 and test1 combined: " + test2);
}

  public MyLinkedList(){
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean add(E value){
    if (size() == 0){
      start = new Node(value, null, null);
      end = start;
      size = 1;
      return true;
    }
    Node oldEnd = end;
    end = new Node(value, null , oldEnd);
    end.prev().setNext(end);
    size++;
    return true;
  }

  public String toString(){
    if (size() == 0){
      return "[]";
    }
    String output = "[";
    Node current = start;
    while (current != null){
      output += current.getData() + ", ";
      if(current.hasNext()){
        current = current.next();
      } else{
        return output.substring(0,output.length()-2) + "]";
      }
    }
    return output + "]";
  }



  public void addBack(E value){
    if(size == 0){
        start = new Node(value, null, null);
        end = start;
        size = 1;
    } else{
        Node target = new Node(value, start, null);
        start.setPrev(target);
        start = target;
        size++;
    }
  }

  public E removeFront(){
    E target = start.getData();
    start = start.next();
    size = size - 1;
    return target;
  }

   public void extend(MyLinkedList<E> other){
       if(other.start != null){
           if (size == 0) start = other.start;
           else end.next = other.start;
           end = other.end;
           size += other.size;
       }
 		// reset the other guy
 		other.size = 0;
 		other.start = null;
 		other.end = null;

    }


}
