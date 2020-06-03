package chapter03;

import java.util.Scanner;

public class EmployeeManagement {
    public void showMenu()
    {
        int option;
        Scanner sc = new Scanner(System.in);

        System.out.println("---------Menu---------");
        System.out.println("1.Hourly paid employee");
        System.out.println("2.Monthly paid employee");
        System.out.println("3. Exit");
        System.out.print("\nChoose the option (1/2/3): ");

        option = sc.nextInt();

        switch (option)
        {
            case 1: Hourly_Employee();
                break;
            case 2: Monthly_Employee();
                break;
            case 3: System.exit(0);
                break;
            default: showMenu();
                break;
        }
    }

    public void Hourly_Employee() {
        int hours,Salary;
        String name,address,email;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name:");
        name = input.nextLine();
        System.out.println("Please enter your address:");
        address = input.nextLine();
        System.out.println("Please enter your email:");
        email = input.nextLine();
        System.out.println("Please enter your working hours:");
        hours = input.nextInt();
        Salary = 20*hours;
        HourlySalary hourlySalary = new HourlySalary(name, address, email, Salary);
        ProcessDetails<HourlySalary> hourly_employee = new ProcessDetails<HourlySalary>(hourlySalary);
        hourly_employee.printDetails();
    }

    public void Monthly_Employee() {
        int months,Salary;
        String name,address,email;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name:");
        name = input.nextLine();
        System.out.println("Please enter your address:");
        address = input.nextLine();
        System.out.println("Please enter your email:");
        email = input.nextLine();
        System.out.println("Please enter your working months:");
        months = input.nextInt();
        Salary = 10000*months;
        MonthlySalary monthlySalary = new MonthlySalary(name, address, email, Salary);
        ProcessDetails<MonthlySalary> month_employee = new ProcessDetails<MonthlySalary>(monthlySalary);
        month_employee.printDetails();
    }

    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        employeeManagement.showMenu();
    }
}
