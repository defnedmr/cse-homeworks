import java.util.ArrayList;
import java.util.Date;

/**
 * Lab08_20230808010
 */
public class Lab08_20230808010 {
    public static void main(String[] args) {
        
    }
}

interface Countable{
    public int getItemCount();
}

interface IInventory<T extends Countable>{
    public void add(T item);
    public void remove(T item);
    public T getItem(int index);
}

interface Rentable{
    public void rentItem(Person renter, Date startDate, Date endDate);
    public boolean isAvailable();
}
interface Buyable{

}

abstract class Person{

}

abstract class Product implements Comparable<Product>{
    private String name;
    private double price;

    Product(String name,Double price){
        setName(name);
        setPrice(price);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    //this > that -> positive integer
    @Override
    public int compareTo(Product that){
        return Double.compare(price, that.price);
    }
    @Override
    public String toString() {
        return (name+ ": "+ price+"$");
    }

}

class Book extends Product{
    private String author;
    private int pages;
    
    
    Book(String name, Double price,String author,int pages){
       super(name, price);
       setAuthor(author);
       setPages(pages); 
    }
    
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    @Override
    public String toString() {
        return this.getName() + " by "+ author;
    }
}
class ColoringBook extends Book implements Rentable{
    private String color;
    
    ColoringBook(String name, Double price,String author, int pages, String color) {
        super(name, price, author, pages);
        this.color=color;
    }
    @Override
    public String toString() {
        return this.getName()+" "+color+" book: "+this.getPrice()+"$";
    }
    @Override
    public void rentItem(Person renter, Date startDate, Date endDate) {
        
        
    }
    @Override
    public boolean isAvailable() {
        return false;
    }
    
}
class Item<T extends Comparable<? super T>& Countable> implements Comparable<T>, Countable{
    private int quantity;
    private T item;

    Item(T item, int quantity){
        this.item=item;
        this.quantity=quantity;
    }
    
    public int getItemCount(){
        return quantity;
    }
    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int compareTo(Item<T> that){
        if(this.quantity== that.getItemCount())
            return 0;
        else if(that.getItemCount() < this.quantity)
            return 1;
        else
            return -1;
    }
    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
@SuppressWarnings("rawtypes")
abstract class Vehicle implements Comparable<Vehicle>{
    private int price;
    private String name;

    Vehicle(String name, int price){
     this.name=name;
    }
   public int getPrice() {
       return price;
   }
   
   
    @Override
    public int compareTo(Vehicle o){
        return Integer.compare(price, o.getPrice());
    }
    @Override
    public String toString() {
        return name+ " : "+price+"$ "; 
    }

}

class Car extends Vehicle implements Rentable{

    Car(String name, int price) {
        super(name, price);
        //TODO Auto-generated constructor stub
    }
    
    public void rentItem(Person renter, Date startDate, Date endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rentItem'");
    }

    @Override
    public boolean isAvailable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAvailable'");
    }
    
}

class Inventory <T extends Comparable<T> & Countable> implements IInventory<T>{
    private T item;
    ArrayList<T> items=new ArrayList<>();
    @Override
    public void add(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    @Override
    public void remove(T item) {
        
    }
    @Override
    public T getItem(int index) {
        
    }
}
class Rented <T extends Rentable, E extends Person>{

}