import java.util.Arrays;

public class Lab05_20230808010 {
    public static void main(String[] args) {
        RAM ram=new RAM("absd", 32);
        CPU cpu=new CPU("dasldm", 3.9);
        Computer comp=new Computer(cpu, ram);
        System.out.println(comp);
    }
    
}
class Computer{
    protected CPU cpu;
    protected RAM ram;

    Computer(CPU cpu,RAM ram){
        this.cpu=cpu;
        this.ram=ram;
    }
    public void run(){
        for (int i = 0; i < ram.getCapacity(); i++) {
            int value1=ram.getValue(0, 0);
            int value2=ram.getValue(i, i);
            int result=-1;
            try {
                result=cpu.compute(value1, value2);
            } catch (ComputationException e) {
                e.printStackTrace();
            }
            ram.setvalue(0, 0, result);
        }
    }
    @Override
    public String toString() {
        return ("Computer: "+cpu+" "+ram);
    }

}

class Laptop extends Computer{
    private int miliAmp;
    private int battery;

    Laptop(CPU cpu, RAM ram, int miliAmp) {
        super(cpu, ram);
        this.miliAmp=miliAmp;
        battery=(miliAmp*30)/100;
    }
    public int batteryPercentage(){
        return battery;
    }
    public void charge(){
        while(battery<(miliAmp*90)/100){
            battery+=2;
        }
    }
    @Override
    public void run() {
        if(battery>(miliAmp*5)/100){
            super.run();
            battery-=(miliAmp*3)/100;
        }
        else
            charge();
    }
    @Override
    public String toString() {
        return super.toString()+" "+ battery;
    }
}

class Desktop extends Computer{
    private Arrays peripherals;

    Desktop(CPU cpu, RAM ram) {
        super(cpu, ram);
        
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
    }
    public void plugIn(String peripheral){

    }
    public String plugOut(){

    }
    public void plugOut(int index){

    }
    @Override
    public String toString() {
        ////
        return super.toString();
    }

}
class CPU{
    private String name;
    private double clock;

    CPU(String name, double clock){
        this.name=name;
        this.clock=clock;
    }
    public int compute(int a,int b) throws ComputationException{
        try {
            Thread.sleep((int)((4/clock)*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result=a+b;
        if(result<0){
            throw new ComputationException(this,result);
        }
        System.out.println("Result: "+result);
        return result;
    }

    public double getClock() {
        return clock;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return String.format("CPU: %s %fGhz", name,clock);
    }

}

class RAM{
    private String type;
    private int capacity;
    private int[][] memory;
    
    RAM(String type, int capacity){
        this.type=type;
        this.capacity=capacity;

    }

    public int getCapacity() {
        return capacity;
    }
    public String getType() {
        return type;
    }
    private void initMemory(){
        memory=new int[capacity][capacity];
        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory.length; j++) {
                memory[i][j]=(int)(Math.random()*10);
            }
        }
    }
    private boolean check(int i,int j){
        if(i<=capacity && j<=capacity){
            return true;

        }
        else{
            return false;
        }
    }
    public int getValue(int i, int j){
        if(check(i, j)){
            return memory[i][j];
        }
        else{
            return (-1);
        }
    }
    public void setvalue(int i,int j,int value){
        if(check(i, j)){
            memory[i][j]=value;
        }
        else{
            /////
        }
    }
    public String toString() {
        return String.format("RAM: %s %dGB", type,capacity);
    }
}

class MemoryException extends RuntimeException{
    private RAM ram;
    MemoryException(RAM ram, int i, int j){
        super("indexes are out of bounds of " +"the memory "+ram+
        " for indexes" + i+ " and "+ j);
        this.ram=ram;
    }
}
class ComputationException extends Exception{
    private CPU cpu;
    public ComputationException(CPU cpu, int result) {
        getMessage();
    }

    @Override
    public String getMessage() {
        return "result is negative";
    }
}