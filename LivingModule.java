package spacestation;

public class LivingModule implements Module {
    private final String name;
    private final int beds;
    private final double powerUsageKw;

    public LivingModule(String name, int beds, double powerUsageKw) {
        this.name = name;
        this.beds = beds;
        this.powerUsageKw = powerUsageKw;
    }

    public String getName() { return name; }
    public int getBeds() { return beds; }
    public double getPowerUsageKw() { return powerUsageKw; }

    @Override
    public void accept(ModuleVisitor visitor) {
        visitor.visitLivingModule(this); // double dispatch: step 2
    }
}
