
package model.visitor;
import persistence.*;

public interface ModuleAbstractSGroupReturnVisitor<R> {
    
    public R handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException;
    public R handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException;
    public R handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException;
    
}
