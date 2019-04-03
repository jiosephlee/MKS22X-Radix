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
    System.out.println("get(0): " + test.get(0));
    System.out.println("set(1,11): " + test.set(1,11));
    System.out.println("get(1): " + test.get(1));
    System.out.println("contains(11): " + test.contains(11));
    System.out.println("indexOf(7): " + test.indexOf(7));
    test.add(1,123);
    System.out.println("add(1,123)...");
    System.out.println("removed: " + test.remove(new Integer(7)));
    System.out.println("remove(new Integer(7))");
    System.out.println("test: " + test);
    MyLinkedList<Integer> test2 = new MyLinkedList<Integer>();
    test2.add(0,123);
    System.out.println("test2: " + test2);
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

  public E get(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    return getNthNode(index).getData();
  }

  private Node getNthNode(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    if (index == 0){
      return start;
    }
    if (index == size()-1){
      return end;
    }
    Node output = start;
    for (int x  = 1; x <= index; x++){
      output = output.next();
    }
    return output;
  }

  public E set(int index,E value){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    Node target = start;
    E output = target.getData();
    for (int x  = 0; x < index; x++){
      target = target.next();
      output = target.getData();
    }
    target.setData(value);
    return output;
  }

  public boolean contains(E value){
    Node target = start;
    for (int x  = 0; x < size(); x++){
      if (target.getData().equals(value)){
        return true;
      }
      target = target.next();
    }
    return false;
  }
  public int indexOf(E value){
    Node target = start;
    for (int x  = 0; x < size(); x++){
      if (target.getData().equals(value)){
        return x;
      }
      target = target.next();
    }
    return -1;
  }

  public void addBack(E value){
    Node target = new Node(value, getNthNode(index), null);
    start = target;
    getNthNode(index).setPrev(target);
    size++;
  }

  public E remove(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    Node target = getNthNode(index);
    if (index == 0){
      getNthNode(index+1).setPrev(null);
      start = getNthNode(index+1);
    } else if (index == size() - 1){
      getNthNode(index - 1).setNext(null);
      end = getNthNode(index - 1);
    }else{
      getNthNode(index - 1).setNext(getNthNode(index + 1));
      getNthNode(index + 1).setPrev(getNthNode(index - 1));
    }
    size = size - 1;
    return target.getData();
  }
  public E removeFront(){
      E toReturn = start.getData();
      start = start.next();
      size--;
      return toReturn;
  }

  public boolean remove(E value){
   if(!contains(value)){
     return false;
   }
   remove(indexOf(value));
   return true;
 }

   public void extend(MyLinkedList<E> other){
     if(other.start != null){
       end.setNext(other.start);
       other.start.setPrev(end);
       end = other.end;
       size = size() + other.size();
       other.size = 0;
       other.start = null;
       other.end = null;
     }
    }


}
