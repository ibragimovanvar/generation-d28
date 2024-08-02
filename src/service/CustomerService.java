package service;

import model.Customer;
import model.CustomerPrintType;

import java.util.List;
import java.util.Scanner;

public class CustomerService {

    public static void printCustomers(List<Customer> customers, CustomerPrintType printType) {
        System.out.println("-----------------------");
        if (customers.isEmpty()) {
            System.out.println("Sizda hali mijozlar mavjud emas !");
        }
        for (Customer customer : customers) {
            if (printType.equals(CustomerPrintType.DEFAULT)){
                System.out.println(customer);
            } else if (printType.equals(CustomerPrintType.IDENTIFIED)) {
                if (customer.isIdentified()){
                    System.out.println(customer);
                }
            }else{
                if (!customer.isIdentified()){
                    System.out.println(customer);
                }
            }
        }
        System.out.println("-----------------------");
    }
    public static Customer getCustomerById(List<Customer> customers, int id) {
        System.out.println("-----------------------");
        if (customers.isEmpty()) {
            System.out.println("Sizda hali mijozlar mavjud emas !");
            return null;
        }
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.println("Foydalanuvchi topildi!");
                return customer;
            }
        }
        System.out.println("Foydalanuvchi topilmadi!");
        System.out.println("-----------------------");
        return null;
    }

    public static void addDebt(List<Customer> customers, Scanner inNum) {
        System.out.print("Mijozni id sini kiriting: ");
        int id = inNum.nextInt();

        Customer customer = CustomerService.getCustomerById(customers, id);
        if (customer != null){
            System.out.print("Mijozni qarzdorligini kiriting:");
            double debt = customer.getDebt() + inNum.nextDouble();
            customer.setDebt(debt);
        }

        System.out.println("Muvaffaqiyatli bajarildi!");
    }
}
