import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Lab03_20230808010 {
    public static void main(String[] args) {
        Car c1=new Car("a", "b", 2010, false, 5, true);
    }
    
    }

abstract class Vehicle{
    protected String brand;
    private String model;
    private int year;
    private boolean isRented;

    Vehicle(String brand,String model,int year, boolean isRented){
        setModel(model);
        setYear(year);
        setRented(isRented);
        setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public boolean isRented(){
        return isRented;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setRented(boolean isRented) {
        this.isRented = isRented;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
    public abstract void run();
}

class Car extends Vehicle{
    private int passengerCapacity;
    private boolean autoTrans;
    Car(String brand, String model, int year, boolean isRented, int passengerCapacity, boolean autoTrans) {
        super(brand, model, year, isRented);
        
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    public void setAutoTrans(boolean autoTrans) {
        this.autoTrans = autoTrans;
    }
    public boolean getAutoTrans(){
        return autoTrans;
    }

    @Override
    public void run() {
        System.out.println("car is running");        
    }
    
    


}

class Truck extends Vehicle{
    private boolean fourWheelDrive;
    private int loadCapacity;
    
    Truck(String brand, String model, int year, boolean isRented,int loadCapacity,boolean fourWheelDrive) {
        super(brand, model, year, isRented);
        setLoadCapacity(loadCapacity);
        setFourWheelDrive(fourWheelDrive);
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }
    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    public boolean getFourWheelDrive(){
        return fourWheelDrive;
    }

    @Override
    public void run() {
        System.out.println("truck is running");
    }

}

class Motorcycle extends Vehicle{
    private int engineVolume;
    private boolean hasABS;

    Motorcycle(String brand, String model, int year, boolean isRented, int engineVolume, boolean hasABS) {
        super(brand, model, year, isRented);
        setEngineVolume(engineVolume);
        setHasABS(hasABS);
    }

    public int getEngineVolume() {
        return engineVolume;
    }
    public boolean hasABS(){
        return hasABS;
    }
    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }
    public void setHasABS(boolean hasABS) {
        this.hasABS = hasABS;
    }
    @Override
    public void run() {
        System.out.println("Motorcycle is running.");
    }
}

class Customer{
    private String firstName;
    private String lastName;
    private int idNumber;

    ArrayList<Vehicle> rentedVehicles;
    ArrayList<RentalContract> rentalContracts;


    Customer(String firstName,String lastName, int capacity){
        setFirstName(firstName);
        idNumber=generateId();
        setLastName(lastName);

        rentedVehicles =new ArrayList<>();
        
    }

    private int generateId(){
        Random rnd=new Random();
        return rnd.nextInt(1000,9999);
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getIdNumber() {
        return idNumber;
    }
    public String getLastName() {
        return lastName;
    }

    public RentalContract rent(Vehicle v){
        Date startDate = new Date();
        Date endDate=new Date();
        RentalContract contract= new RentalContract(this, v, startDate, endDate);
        rentalContracts.add(contract);
        rentedVehicles.add(v);
        return contract;
    }
    public void returnVehicle(){

    }
}

class RentalContract{
    private Customer customer;
    private Vehicle rentalVehicle;
    private Date startDate;
    private Date finishDate;

    RentalContract(Customer customer,Vehicle rentalVehicle,Date startDate,Date finishDate){
        setCustomer(customer);
        setFinishDate(finishDate);
        setRentalVehicle(rentalVehicle);
        setStartDate(startDate);
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    public void setRentalVehicle(Vehicle rentalVehicle) {
        this.rentalVehicle = rentalVehicle;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Date getFinishDate() {
        return finishDate;
    }
    public Vehicle getRentalVehicle() {
        return rentalVehicle;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void calculatePeriod(){
        
        System.out.println("");
    }
    public Date period(){
        return new Date(finishDate.getTime() - startDate.getTime());
    }
}