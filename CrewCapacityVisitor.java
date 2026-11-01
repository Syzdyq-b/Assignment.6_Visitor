package spacestation;

public class CrewCapacityVisitor implements ModuleVisitor {
    private int capacity;

    @Override
    public void visitLivingModule(LivingModule module) {
        capacity += module.getBeds();
    }

    @Override
    public void visitLabModule(LabModule module) {
        capacity += 1; // one operator seat per lab
    }

    @Override
    public void visitSolarModule(SolarModule module) {
        // unmanned: no crew
    }

    public int getCapacity() { return capacity; }
}
