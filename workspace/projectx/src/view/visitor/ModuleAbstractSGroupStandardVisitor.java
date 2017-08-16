
package view.visitor;

import view.*;

public abstract class ModuleAbstractSGroupStandardVisitor implements ModuleAbstractSGroupVisitor {
    
    public void handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException{
        this.standardHandling(moduleGroupSGroup);
    }
    public void handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException{
        this.standardHandling(moduleAtomarSGroup);
    }
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException{
        this.standardHandling(moduleWithUnitsSGroup);
    }
    protected abstract void standardHandling(ModuleAbstractSGroupView moduleAbstractSGroup) throws ModelException;
}
