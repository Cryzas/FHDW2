
package model.visitor;

import persistence.*;

public abstract class ModuleAbstractSGroupStandardVisitor implements ModuleAbstractSGroupVisitor {
    
    public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException{
        this.standardHandling(moduleGroupSGroup);
    }
    public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException{
        this.standardHandling(moduleAtomarSGroup);
    }
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException{
        this.standardHandling(moduleWithUnitsSGroup);
    }
    protected abstract void standardHandling(ModuleAbstractSGroup4Public moduleAbstractSGroup) throws PersistenceException;
}
