package spacestation;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private final List<Module> modules = new ArrayList<>();

    public void addModule(Module module) { modules.add(module); }

    public void accept(ModuleVisitor visitor) {
        for (Module module : modules) {
            module.accept(visitor);
        }
    }
}
