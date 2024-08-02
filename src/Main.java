import model.Customer;
import model.CustomerPrintType;
import service.CustomerService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner inTxt = new Scanner(System.in);
    static Scanner inNum = new Scanner(System.in);
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("------------------ MIJOZLAR RO'YXATLOVCHI DASTURGA XUSH KELIBSIZ ----------------");
        while (true) {
            System.out.print(
                    "1. Mijozlar ro'yxati\n" +
                    "2. Mijoz qo'shish\n" +
                    "3. Mijozni o'chirish\n" +
                    "4. Mijozni ishonchliligini tasdiqlash\n" +
                    "5. Mijozga qarzdorlik qo'shish\n" +
                    "6. Mijozdan qarzdorlik o'chirish\n" +
                    "7. Qarzdor mijozlarni topish\n" +
                    "8. Ishonchli mijozlarni topish\n" +
                    "9. Dasturdan chiqish\n" +
                    "-----kiritish---------> "
            );
            int choice = inNum.nextInt();
            switch (choice) {
                case 1 -> {
                    CustomerService.printCustomers(customers, CustomerPrintType.DEFAULT);
                }
                case 2 -> {
                    System.out.print("Yangi mijozni ism familiyasini kiriitng : ");
                    String fullName = inTxt.nextLine();

                    System.out.print("Yangi mijozni raqamini kiriting +998 : ");
                    String phoneNumber = inTxt.nextLine();

                    System.out.print("Yangi mijozni qarzini kiriting : ");
                    double debt = inNum.nextDouble();

                    System.out.print("Bu mijoz ishonchlimi ? y/n :");
                    boolean identified = false;
                    String choiceCus = inTxt.nextLine();

                    if (choiceCus.equals("y")) {
                        identified = true;
                    }

                    Customer newCustomer = new Customer(fullName, phoneNumber,
                            debt, identified);

                    customers.add(newCustomer);
                    System.out.println("Mijoz muvaffaqiyatli bazaga qo'shildi !");
                }
                case 3 -> {
                    CustomerService.printCustomers(customers, CustomerPrintType.DEFAULT);
                    System.out.print("id sini kiriting:");
                    int enteredId = inNum.nextInt();
                    Customer foundCustomer = CustomerService.getCustomerById(customers, enteredId);
                    if (foundCustomer != null){
                        customers.remove(foundCustomer);
                        System.out.println("------ Foydalanuvchi o'chirildi! ------");
                    }
                }
                case 4 -> {
                    System.out.println("Case 4");
                }
                case 5 -> {
                    CustomerService.addDebt(customers, inNum);
                }
                case 6 -> {

                }
                case 7 -> {

                }
                case 8 -> {
                    CustomerService.printCustomers(customers, CustomerPrintType.IDENTIFIED);
                }
                default -> {
                    System.out.println("Dastur o'z ishini tugatdi");
                    return;
                }
            }
        }


    }
}