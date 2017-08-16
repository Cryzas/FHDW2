
package view.visitor;
import view.*;

public interface ModuleAbstractVisitor {
    
    public void handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException;
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException;
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException;
    
}
