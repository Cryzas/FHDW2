
package view.visitor;

import view.*;

public abstract class ModuleAbstractStandardVisitor implements ModuleAbstractVisitor {
    
    public void handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException{
        this.standardHandling(moduleGroup);
    }
    protected abstract void standardHandling(ModuleAbstractView moduleAbstract) throws ModelException;
}
