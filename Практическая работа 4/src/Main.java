import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int zp = 0;

        List<Employee> staff = new ArrayList<>();
        List<Employee> Sal = new ArrayList<>();
        Company comp = new Company();

        Manager mn = new Manager();
        Employee emp = new Employee("Менеджер", "AA", 20000, mn);

        TopManager Tmn = new TopManager(comp);
        Employee emp1 = new Employee("Топ менеджер", "BB", 200000, Tmn);

        comp.hire(emp);
        comp.hire(emp1);
        System.out.println("Доход компании с двумя работниками - " + comp.getIncome());

        for (int i = 0; i < 180; i++)
        {
            zp = 10000 + (int)(Math.random()*(10001));
            staff.add(new Employee("CC", "AA", zp, new Operator()));
        }
        for (int i = 0; i < 80; i++)
        {
            staff.add(new Employee("Менеджер", "CC", 100000, new Manager()));
        }

        comp.hireAll(staff);

        System.out.println("Доход компании - " + comp.getIncome());

        System.out.println("15 максимальных зарплат: ");
        Sal = comp.getTopSalaryStaff(15);
        for (int i = 0; i < Sal.size(); i++)
            System.out.println(Sal.get(i).getPosition().calc_zp(Sal.get(i).getBase_salary()));
        Sal.clear();
        Sal = comp.getLowestSalaryStaff(30);
        System.out.println("30 минимальных зарплат: ");
        for (int i = 0; i < Sal.size(); i++)
            System.out.println(Sal.get(i).getPosition().calc_zp(Sal.get(i).getBase_salary()));

        comp.fire(emp1);
        comp.fire_half();


        Sal.clear();
        System.out.println("После увольнения");
        System.out.println("15 максимальных зарплат: ");
        Sal = comp.getTopSalaryStaff(15);
        for (int i = 0; i < Sal.size(); i++)
            System.out.println(Sal.get(i).getPosition().calc_zp(Sal.get(i).getBase_salary()));
        Sal.clear();
        Sal = comp.getLowestSalaryStaff(30);
        System.out.println("30 минимальных зарплат: ");
        for (int i = 0; i < Sal.size(); i++)
            System.out.println(Sal.get(i).getPosition().calc_zp(Sal.get(i).getBase_salary()));
    }

}
