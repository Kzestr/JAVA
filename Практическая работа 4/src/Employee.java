public class Employee implements Comparable<Employee> {
    private String name, surname;
    private double zp;
    private EmployeePosition position;

    public double getBase_salary() {
        return zp;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public Employee(String name, String surname, int base_salary, EmployeePosition position) {
        this.name = name;
        this.surname = surname;
        this.zp = base_salary;
        this.position = position;
    }

    @Override
    public int compareTo(Employee o) {
        double a = this.position.calc_zp(this.zp);
        double b = o.getPosition().calc_zp(o.getBase_salary());
        if (a < b)
            return (1);
        else if (a > b)
            return (-1);
        else
            return 0;
    }
}
