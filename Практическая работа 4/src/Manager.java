public class Manager implements EmployeePosition{

    private int x;
    public Manager() {
        x = 115000 + (int)(Math.random()*(25001));
    }

    public int GetIn()
    {
        return (x);
    }


    @Override
    public String getJobTitle() {
        return "Менеджер";
    }

    @Override
    public double calc_zp(double zp) {
        return x + zp;
    }
}
