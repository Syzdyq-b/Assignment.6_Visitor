package spacestation;

public class PowerBalanceVisitor implements ModuleVisitor {
    private double produced;
    private double consumed;

    @Override
    public void visitLivingModule(LivingModule module) {
        consumed += module.getPowerUsageKw();
    }

    @Override
    public void visitLabModule(LabModule module) {
        consumed += module.getPowerUsageKw();
    }

    @Override
    public void visitSolarModule(SolarModule module) {
        produced += module.getPanels() * module.getOutputPerPanelKw();
    }

    public double getBalanceKw() { return produced - consumed; }
}
