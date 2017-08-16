
package view.visitor;
import view.*;

public interface ModuleAbstractSGroupVisitor {
    
    public void handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException;
    public void handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException;
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException;
    
}
