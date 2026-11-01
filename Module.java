package spacestation;

public interface Module {
    void accept(ModuleVisitor visitor);
}
