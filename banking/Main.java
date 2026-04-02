import java.util.*;
class Customer{
    int custo_id;
    String name;
    String address;

void display(){
    System.out.print("CustomerId "+custo_id) ;
    System.out.print("Name"+name);
    System.out.print("Address" +address);
}
}
class Account {
    int acc_no;
    int balance;
     Account() {
        acc_no= 0;
        balance = 0;
    }

    Account(int acc_no, int balance) {
        this.acc_no = acc_no;
        this.balance = balance;
    }
    void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }
    void withdrawl(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawl: " + amount);
        }
    }
}

class Transaction {
    private int trans_id;
    private int amount;

    void set(int trans_id, int amount) {
        this.trans_id = trans_id;
        this.amount = amount;
    }
    void incrementId() {
    trans_id++;
}

    void get() {
        System.out.println("Transaction ID: " + trans_id);
        System.out.println("Amount: " + amount);
    }
}
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        Account a=new Account();
        Transaction t=new Transaction();
        System.out.print ("Enter the customer ID: ");
        c.custo_id = sc.nextInt();
        System. out.print("Enter your name!");
        c.name=sc.next();
        System.out.print("Enter the address");
         c.address=sc.next();
         System.out.print("Enter the Account Number");
         a.acc_no=sc.nextInt();
         int choice;
         System.out.print ("BANK SYSTEM");
         System.out.print("1. DEPOIST");
         System.out.print("2. WITHDRAWL");
         System.out.print("3. CUSTOMER DETAILS");
         System.out.print("4.Exit");
         System.out.print(" Enter your choice: ");
         choice=sc.nextInt();
         switch (choice){
             case 1:
                 System.out.print("Enter the amount to deposit: ");
                 int dep = sc.nextInt();
                 a.deposit(dep);
                 t.incrementId();
                 t.amount=dep;
                 t.get();
                 break;
                 case 2:
                     System.out.print("Enter the amount to withdraw: ");
                     int amt=sc.nextInt();
                     a.withdrawl(amt);
                     t.incrementId();
                     t.amount = amt;
                     t.get();
                     break;
                     case 3:
                         c.display();
                         break;
                         case 4:
                             System.out.print("Thank you");
                             break;
                             default:
                             System.out.print("Invaild choice");
             
         }
    }
}