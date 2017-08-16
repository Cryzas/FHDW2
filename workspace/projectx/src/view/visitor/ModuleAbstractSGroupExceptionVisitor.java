
package view.visitor;
import view.*;

public interface ModuleAbstractSGroupExceptionVisitor<E extends view.UserException> {
    
    public void handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException, E;
    public void handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException, E;
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException, E;
    
}
