
package model.visitor;

import persistence.*;

public abstract class ModuleAbstractStandardVisitor implements ModuleAbstractVisitor {
    
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.standardHandling(moduleWithUnits);
    }
    protected abstract void standardHandling(ModuleAbstract4Public moduleAbstract) throws PersistenceException;
}
