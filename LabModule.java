package spacestation;

public class LabModule implements Module {
    private final String name;
    private final int experiments;
    private final double powerUsageKw;

    public LabModule(String name, int experiments, double powerUsageKw) {
        this.name = name;
        this.experiments = experiments;
        this.powerUsageKw = powerUsageKw;
    }

    public String getName() { return name; }
    public int getExperiments() { return experiments; }
    public double getPowerUsageKw() { return powerUsageKw; }

    @Override
    public void accept(ModuleVisitor visitor) {
        visitor.visitLabModule(this);
    }
}
