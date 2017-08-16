
package view.visitor;
import view.*;

public interface ModuleAbstractSGroupReturnVisitor<R> {
    
    public R handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException;
    public R handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException;
    public R handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException;
    
}
