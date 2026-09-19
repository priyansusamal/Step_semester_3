package classes_and_objects_revision.assigment_problems;

class CompanyEmployee {

    String empName;
    double salary;

    static String companyName =
        "Bright Horizon Technologies";

    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println(
            "Employees on record: " + employeeCount
        );
    }
}

public class EmployeeCompanyInfo {

    public static void main(String[] args) {

        new CompanyEmployee("Ravi", 50000);
        new CompanyEmployee("Anitha", 60000);
        new CompanyEmployee("Karthik", 55000);

        CompanyEmployee.printCompanyInfo();
    }
}