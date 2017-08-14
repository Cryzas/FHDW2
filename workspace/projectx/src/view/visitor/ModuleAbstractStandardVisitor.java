
package view.visitor;

import view.*;

public abstract class ModuleAbstractStandardVisitor implements ModuleAbstractVisitor {
    
    public void handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.standardHandling(moduleWithUnits);
    }
    protected abstract void standardHandling(ModuleAbstractView moduleAbstract) throws ModelException;
}
