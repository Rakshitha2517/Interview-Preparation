import java.util.*;

class Customer {
    String id;
    String name;
    String password;
    void registration(String id, String name,String password) { 
        this.id=id;
        this.name=name;
        this.password=password;
        System.out.println("Registration successfull");
        }
        void login(HashMap<String,Customer>user,String id,String password){
           if(user.containsKey(id) && user.get(id).password.equals(password)){
               System.out.println("Login successful");
               
           }
           else {
               System.out.println("Invalid ID or Password");
               
           }
        }
    void display() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        }
}
class Account {
    int acc_no;
    int balance;

    Account() {
        acc_no=1;
        balance=100; 
    }

    Account(int acc_no,int balance) {
        this.acc_no=acc_no;
        this.balance=balance;
    }

    void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        System.out.println("-----------------------------------");
    }

    void withdrawl(int amount) {
        if (amount>balance) {
            System.out.println("Insufficient balance");
            System.out.println("--------------------------------");
        } 
        else {
            balance=balance-amount;
            System.out.println("Withdrawal: "+amount);
            System.out.println("---------------------------------");
        }
    }
    void showBalance() {
        System.out.println("Current Balance: "+balance);
        System.out.println("-----------------------------------");
    }
}

class Transaction {
    private int trans_id;
    private int amount;
    Transaction(int trans_id,int amount){
        this.trans_id=trans_id;
        this.amount=amount;
    }

    void displayTransaction(){
        System.out.println("Transaction ID: " + trans_id+ " Amount: " + amount);
        System.out.println("--------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,Customer> user=new HashMap<>();
        ArrayList<Transaction> list=new ArrayList<>();
        int t_id=0; 
        Customer c=new Customer();
        Account a=new Account();
        int choice;

        do {
            System.out.println("\n---------- BANK SYSTEM ------------");
            System.out.println("1. REGISTRATION");
            System.out.println("2. LOGIN");
            System.out.println("3. DEPOSIT");
            System.out.println("4. WITHDRAWAL");
            System.out.println("5. BALANCE");
            System.out.println("6. CUSTOMER DETAILS");
            System.out.println("7. TRANSACTION HISTORY");
            System.out.println("8. EXIT");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter User Id:");
                    String id=sc.nextLine();
                    if(id.length()<=20){
                    System.out.print("Enter User Name:");
                    String name=sc.nextLine();
                    System.out.print("Enter User Password:");
                    String password =sc.nextLine();
                    c.registration(id,name,password);
                    user.put(id,c);

                    }
                    else{
                        System.out.println("!!User id is too long!!");
                    }
                    break;
                case 2:
                    System.out.print("Enter User Id: ");
                    String loginid = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String loginpass = sc.nextLine();
                    c.login(user,loginid,loginpass);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    int dep=sc.nextInt();
                    a.deposit(dep);
                    a.showBalance();
                   t_id++;
                   list.add(new Transaction(t_id,dep));  
                    break;
                case 4:
                    System.out.print("Enter amount to withdraw: ");
                    int amt=sc.nextInt();
                    a.withdrawl(amt);
                    a.showBalance();
                    t_id++;
                   list.add(new Transaction(t_id,amt));  
                    break;
                case 5:
                    a.showBalance();
                    break;

                case 6:
                    c.display();
                    break;
                case 7:
                    System.out.println("Transaction History:");
                    for (Transaction t:list)
                        t.displayTransaction();
                        break;
                case 8:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        while (choice!=8);
    }
}
