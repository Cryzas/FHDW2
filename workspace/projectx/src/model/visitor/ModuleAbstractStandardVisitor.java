
package model.visitor;

import persistence.*;

public abstract class ModuleAbstractStandardVisitor implements ModuleAbstractVisitor {
    
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.standardHandling(moduleGroup);
    }
    protected abstract void standardHandling(ModuleAbstract4Public moduleAbstract) throws PersistenceException;
}
