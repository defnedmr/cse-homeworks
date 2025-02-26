import java.util.ArrayList;

public  class Lab04_20230808010 {
    public static void main(String[] args) {
    int[] numbers=new int[5];
        User user=null;
    try {
         user=new User(5,"abc");
        
    } catch (UserException e) {
       System.out.println(e.getMessage());
    }
    System.out.println("continues");
    //System.out.println(user.getId());

    }
    public static void method() throws Exception{

    }
    
}

class UserException extends Exception{
    private User user;

    UserException(String name,int id){
        super("exception occured with "+name+" "+id);
    }
    @Override
    public String getMessage() {
        
        return String.format("user id has an exception", user);
    }
}

class User{
    private int id;
    private String name;
    ArrayList <BankAccount> accounts;

    User(int id, String name) throws UserException{
        
        this.id=id;
        this.name=name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    
    public BankAccount geAccount(int id){
        for(BankAccount bankAccount : accounts){
            if(bankAccount.getId()==id){
                return bankAccount;
            }
            throw new AccountNotfoundException(this, id);
    
        }
        return null;
    }

    public void addAccount(BankAccount bankAccount){
        for(BankAccount account: accounts){
            if(bankAccount.getId() ==account.getId()){
                throw new AccountNotfoundException(this,bankAccount.getId());
            }
        }
    }
    @Override
    public String toString() {
        return String.format("user name; %s , user id: %d",name,id );
    }
}

class InvalidOperationException extends RuntimeException{
    User user;

    InvalidOperationException(User user){

        this.user=user;
    }

    
    
    public String getMessage() {
        return "Exception occued with user "+user;
    }
}

class AccountNotfoundException extends InvalidOperationException{
    private int id;

    AccountNotfoundException(User user, int id){
        super(user);
        this.id=id;
    }
    @Override
    public String getMessage() {
        return String.format("Account not found with id %d of user %o", id, user);
    }
}
class AccountAlreadyExists extends InvalidOperationException{
    private int id;
    AccountAlreadyExists(User user, int id){
        super(user);
        this.id=id;
    }
    @Override
    public String getMessage() {
        return "Account already exists";
    }
}
class BankAccount{
    private int id;
    private User user;
    private double balance;

    BankAccount(int id, User user, double balance) throws InvalidAmountException{
        this.id=id;
        this.user=user;
        if(balance<0)
            throw new InvalidAmountException(user,id,balance);
        this.balance=balance;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}

class InvalidAmountException extends Exception{
    private User user;
    private int id;
    private double balance;
    
    InvalidAmountException(User user,int id,double balance){
        this.balance=balance;
        this.user=user;
        this.id=id;
    }

    @Override
    public String getMessage() {
        return String.format("user %o has invalid balance %.2f with account id %d",user,balance,id);
    }

}