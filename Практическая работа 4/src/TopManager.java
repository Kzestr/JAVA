public class TopManager implements EmployeePosition{

    Company info;

    public TopManager(Company info) {
        this.info = info;
    }

    @Override
    public String getJobTitle() {
        return "Топ менеджер";
    }

    @Override
    public double calc_zp(double zp) {
        double x;
        x = (info.getIncome() > 10000000) ? (zp + zp * 1.5) : zp;
        return (x);
    }
}
