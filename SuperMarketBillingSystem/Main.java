import java.util.*;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class Customer{
    private int customer_Id;
    private String customer_Name;
    private String phone_No;
    Customer(int customer_Id,String customer_Name,String phone_No){
        this.customer_Id=customer_Id;
        this.customer_Name=customer_Name;
        this.phone_No=phone_No;
    }
    public int getCustomerId(){
        return customer_Id;
    }
    public String getCustomerName(){
        return customer_Name;
    }
}
class Product{
     int product_Id;
     String product_Name;
     double price;
     int quantity;
    Product(int product_Id,String product_Name,double price,int quantity){
        this.product_Id=product_Id;
        this.product_Name=product_Name;
        this.price=price;
        this.quantity=quantity;
    }
    void displayproduct(){
            System.out.print("\t"+product_Name+ "\t"+price+"\t"+quantity+"\t"+(price*quantity));
            
    }
    
}
class Bill{
    int bill_No;
    LocalDateTime billDate;
    double total_amt;
    Customer customer;
    ArrayList<Product>item;
    Bill(Customer customer) {
    this.customer=customer;
    this.item=new ArrayList<>();
    this.billDate=LocalDateTime.now();
}
    
    public void addproduct(Product p){
        
        item.add(p);
    }
    public void calculate(){
        total_amt=0;
        for(Product p: item)
        total_amt+=p.price*p.quantity;
        
    }
    public void print(){
        System.out.println("--------- VR Market---------");
        System.out.println("------------- Bill -------------");
        System.out.println("Customer Name: "+customer.getCustomerName());
        System.out.println("Customer Id: "+customer.getCustomerId());
        System.out.println("Date & Time: " + billDate);
        System.out.println("----------------------------------------");
        for(Product p: item){
        System.out.println("\t"+p.product_Name+ "\t"+p.price+"\t"+p.quantity+"\t"+(p.price * p.quantity));
            System.out.println("--------------------------------------");
        }
        System.out.println("\tTotal Amount: "+total_amt);
    }
    
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LocalDateTime now=LocalDateTime.now();
        ZonedDateTime n=ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateTime=now.format(format);
        System.out.print("Enter Customer Name: ");
        String name=sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone=sc.next();
      Customer c;
      if(phone.length()==10 && phone.matches("[0-9]+")) {
          c=new Customer(1,name,phone);
      } 
      else {
          System.out.println("Invalid phone number!");
          return; 
      }
        Bill b=new Bill(c);
        int choice;
        int qty;
        while(true){
            System.out.println("1.Milk  2.Rice  3.Soap 4. 5 Star  5.KitKat 0.Exit");
            System.out.print("Enter choice: ");
            choice=sc.nextInt();
            if (choice==0) 
            break;
            System.out.print("Enter quantity: ");
            qty=sc.nextInt();
            switch(choice){
                case 1:
                    b.addproduct(new Product(1, "Milk", 25, qty));
                    break;
                case 2:
                    b.addproduct(new Product(2, "Rice", 65, qty));
                    break;
                case 3:
                    b.addproduct(new Product(3, "Soap", 95, qty));
                    break;
                case 4:
                    b.addproduct(new Product(4, "5 Star",10,qty));
                    break;
                    case 5:
                        b.addproduct(new Product(5, "KitKat",25,qty));
                        break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        b.calculate();
        b.print();
    }
}
