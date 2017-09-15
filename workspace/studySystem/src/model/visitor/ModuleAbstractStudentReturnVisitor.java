
package model.visitor;
import persistence.*;

public interface ModuleAbstractStudentReturnVisitor<R> {
    
    public R handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException;
    public R handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException;
    public R handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException;
    
}
