
package model.visitor;
import persistence.*;

public interface ModuleAbstractSGroupReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException, E;
    public R handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException, E;
    public R handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException, E;
    
}
