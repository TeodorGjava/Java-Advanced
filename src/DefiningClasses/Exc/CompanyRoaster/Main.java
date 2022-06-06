package DefiningClasses.Exc.CompanyRoaster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        Map<String, Department> departmentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Employee employee = null;
            String[] line = sc.nextLine().split(" ");
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];
            switch (line.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (line[line.length - 1].contains("@")) {
                        employee = new Employee(name, salary, position, department, line[4]);
                    } else {
                        employee = new Employee(name, salary, position, department, Integer.parseInt(line[4]));
                    }
                    break;
                case 6:
                    String email = line[4];
                    int age = Integer.parseInt(line[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            departmentMap.putIfAbsent(department, new Department(department));
            departmentMap.get(department).getEmployees().add(employee);
        }
        Department highestPayed = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(x -> x.getValue().avgSalary()))
                .get()
                .getValue();
        System.out.printf("Highest Average Salary: %s%n",highestPayed.getDepartmentName());
        highestPayed.getEmployees().stream().sorted((y1,y2)-> (int) (y2.getSalary()-y1.getSalary())).forEach(x->{
            System.out.printf("%s %.2f %s %d%n",x.getName(),x.getSalary(),x.getEmail(),x.getAge());
        });


    }
}

