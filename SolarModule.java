package spacestation;

public class SolarModule implements Module {
    private final String name;
    private final int panels;
    private final double outputPerPanelKw;

    public SolarModule(String name, int panels, double outputPerPanelKw) {
        this.name = name;
        this.panels = panels;
        this.outputPerPanelKw = outputPerPanelKw;
    }

    public String getName() { return name; }
    public int getPanels() { return panels; }
    public double getOutputPerPanelKw() { return outputPerPanelKw; }

    @Override
    public void accept(ModuleVisitor visitor) {
        visitor.visitSolarModule(this);
    }
}
