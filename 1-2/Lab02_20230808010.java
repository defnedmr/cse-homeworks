public class Lab02_20230808010 {
    public static void main(String[] args) {
        Car c1=new Car("abc", "acasd");
        Wallet kahverengi=new Wallet("kahverengi");
        Person defne=new Person("defne", c1, kahverengi);
        defne.think();
        System.out.println(defne.think());

    }
    
}

//property= datafield with getter&setter methods

class Rectangle{
    private double length;
    private double width;

    Rectangle(double length, double width){      
         //new way 
        setLength(length);
        this.width=width;
    }

    public void setLength(double length) {
        if(length>0)
        {this.length = length;}
        else
            System.out.println("Error: invalid value.");
    }
    public void setWidth(double width) {
        if(width>0)
        {this.width = width;}
        else 
            System.out.println("Error: invalid value.");
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

    public double getArea(){
        return width*length;
    }
    public double getPerimeter(){
        return 2*(length+width);
    }

    
    public String toString() {
        return String.format("Rectangle's length is %.2f, and width is %.2f.\n", length,width);
    }

}

class Car{
    private String model;
    private String color;
    private int speed;
    private boolean isOn;
    private int acceleration;

    Car(String model,String color){
        this.model=model;
        this.color=color;
    }
    Car(String model,String color, int acceleration){
        this(model,color);
        this.acceleration=acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }
    public void start(){
        if(!isOn){
            isOn=true;
            accelerate();
            System.out.println("Car has started.");
        }
        else
             System.out.println("car is already on.");
    }
    public void stop(){
        if(isOn){
            speed=0;
            isOn=false;
            System.out.println("Car has stopped.");
        }
        else
             System.out.println("car is already off.");
        
    }
    public void accelerate(){
        if(isOn)
            speed+=acceleration;
    }
    public void accelerate(int acceleration){
        this.acceleration=acceleration;
        accelerate();
    }
    
    public String toString() {
        if(!isOn)
            return String.format("Color: %s, Model:%s", color,model);
        else
            return String.format("Color: %s, Model:%s, Current Speed: %d, Acceleration:%d", color,model,speed,acceleration);
    }    
}

class Wallet{
    private String color;
    private int amount;
    //private 
    Wallet(String color){
        this.color=color;
    }
    Wallet(String color,int amount){
        this(color);
        this.amount=amount;
    }

    public String getColor() {
        return color;
    }
    public int getAmount() {
        return amount;
    }

    public void addMoney(int money){
        if(money>=0){
            amount+=money;
        }
        else
            throw new IllegalArgumentException("Error: invalid money amount");
    }
    public void removeMoney(int money){
        if(money<=amount){
            amount-=money;
        }
        else    
           throw new IllegalArgumentException("You don't have enough money");
    }

    @Override
    public String toString() {
        return String.format("Wallet[%s]",color);
    }
}

class Brain {
    private String size;
    private Person person;

    Brain(Person person){
        this.person=person;
        size="Medium";

    }
    Brain(Person person, String size){
        setPerson(person);
        setSize(size);
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public Person getPerson() {
        return person;
    }
    public String getSize() {
        return size;
    }
    
    //i assumed there's three types of brain
    //small, medium and big
    public int chance(){
        if(size.equalsIgnoreCase("small")){
            return 1;
        }
        else if(size.equalsIgnoreCase("medium")){
            return 2;
        }
        else{
            return 3;
        }

    }
    public boolean remember(){
     double chance=Math.random()*4;   
      if(chance<chance()){
        return true;
      }
      else
        return false;
    }

    @Override
    public String toString() {
        return person.getName()+" "+size;
    }
}

class Item{
    private String name;
    private int value;

    Item(String name,int value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    
    public String toString() {
        return String.format("%s (%d)", name,value);
    }
}

class Person{
    private String name;
    private Car car;
    private Wallet wallet;
    private Brain brain;
    
    Person(String name){
        this.name=name;
        this.brain=new Brain(null);
        
    }
    Person(String name, Car car, Wallet wallet){
        this.name=name;
        this.car=car;
        this.wallet=wallet;
        this.brain=new Brain(null);
    }

    public String getName() {
        return name;
    }
    public void drive(){
        if(car!=null){
            car.start();
            if(think())
                car.accelerate();
        }
    }
    public boolean think(){
        return brain.remember();
    }

    public void buy(Item item){
        if(wallet!=null){
            if(wallet.getAmount()<item.getValue()){
                System.out.println("you don't have enough money.");
            }
            else{
                ////////////
            }
        }
        else
            System.out.println("You dont even have a wallet.");
    }

}