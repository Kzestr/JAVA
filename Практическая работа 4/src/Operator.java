public class Operator implements EmployeePosition{

    @Override
    public String getJobTitle() {
        return "Оператор";
    }

    @Override
    public double calc_zp(double zp) {
        return (zp);
    }
}
