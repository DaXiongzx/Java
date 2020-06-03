package chapter03;

import java.lang.reflect.Field;

public class ProcessDetails<T>{
    public T Employee;

    public ProcessDetails(T a) {
        Employee = a;
    }

    public void printDetails() {

        try {
            Field nameField = Employee.getClass().getDeclaredField("name");
            Object nameValue = nameField.get(Employee);
            Field addressField = Employee.getClass().getDeclaredField("address");
            Object addressValue = addressField.get(Employee);
            Field emailField= Employee.getClass().getDeclaredField("email");
            Object emailValue = emailField.get(Employee);
            Field SalaryField = Employee.getClass().getDeclaredField("Salary");
            Object SalaryValue = SalaryField.get(Employee);
            System.out.println("Employee name is " + nameValue);
            System.out.println("Employee address is " + addressValue);
            System.out.println("Employee email is " + emailValue);
            System.out.println("Employee Salary is " + SalaryValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

