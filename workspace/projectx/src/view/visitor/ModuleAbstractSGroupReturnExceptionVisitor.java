
package view.visitor;
import view.*;

public interface ModuleAbstractSGroupReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException, E;
    public R handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException, E;
    public R handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException, E;
    
}
