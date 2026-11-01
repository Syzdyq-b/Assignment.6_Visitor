package spacestation;

public interface ModuleVisitor {
    void visitLivingModule(LivingModule module);
    void visitLabModule(LabModule module);
    void visitSolarModule(SolarModule module);
}
