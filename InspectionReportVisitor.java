package spacestation;

public class InspectionReportVisitor implements ModuleVisitor {
    private final StringBuilder report = new StringBuilder();

    @Override
    public void visitLivingModule(LivingModule module) {
        report.append("Living  '").append(module.getName())
              .append("': check air filters, ").append(module.getBeds()).append(" beds\n");
    }

    @Override
    public void visitLabModule(LabModule module) {
        report.append("Lab     '").append(module.getName())
              .append("': calibrate instruments, ").append(module.getExperiments()).append(" experiments\n");
    }

    @Override
    public void visitSolarModule(SolarModule module) {
        report.append("Solar   '").append(module.getName())
              .append("': clean ").append(module.getPanels()).append(" panels\n");
    }

    public String getReport() { return report.toString(); }
}
