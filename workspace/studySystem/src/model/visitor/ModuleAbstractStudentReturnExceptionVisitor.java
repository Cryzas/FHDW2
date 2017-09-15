
package model.visitor;
import persistence.*;

public interface ModuleAbstractStudentReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException, E;
    public R handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException, E;
    public R handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException, E;
    
}
