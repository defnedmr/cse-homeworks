import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
/**
 * Lab10_20230808010
 */
public class Lab10_20230808010 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>(1);
        LinkedList<Integer> linkedList=new LinkedList<>();
        int n=100000;
        long start=System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        
        long end=System.currentTimeMillis();
        System.out.println("ms: "+(end-start));

        start=System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);    
        }
        end=System.currentTimeMillis();
        System.out.println("ms: "+(end-start));

        ArrayList<Student> sList=new ArrayList<>();
        sList.sort(new StudentComparatorAlphabetical());
        sList.sort(new StudentComparatorNumeric());
        Collections.sort(sList);
    }
    
}
interface Iterator<E> extends java.util.Iterator<E>{
    boolean hasNext();
    E next();
    void remove();
}
interface Iterable<E> extends java.lang.Iterable<E>{
    Iterator<E> iterator();
}
interface Comparator<E> extends java.util.Comparator<E>{
    int compare(E x, E y);
}
class Student implements Comparable<Student>{
    String name;
    int s_number;
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.s_number, o.s_number);
    }
    public boolean equals(Object o){
        return true;
    }
     

}
class StudentComparatorAlphabetical implements Comparator<Student>{

    @Override
    public int compare(Student x, Student y) {
        return x.name.compareTo(y.name);
    }
}
class StudentComparatorNumeric implements Comparator<Student>{

    @Override
    public int compare(Student x, Student y) {
        return Double.compare(x.s_number, y.s_number);
    }

}
interface Collection<E> extends Iterable<E>{
    boolean isEmtpy();
    int size();

}
interface List<E> extends Collection<E> {
    boolean add(int index, E element);
    boolean add(E element);
    boolean remove(Object o); 
    E set(int index, E element);
    E get(int index);
}
interface Stack<E> extends Collection<E>{
    E peek();
    E pop();
    boolean push(E element);
}
interface Queue<E> extends Collection<E>{
    boolean offer(E element);
    E peek();
    E poll();
} 
interface Deque<E> extends Queue<E>{
    boolean addFirst(E element);
    boolean addLAst(E element);
    E getFirst();
    E getLast();
    E removeFirst();
    E removeLast();

}