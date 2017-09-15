
package model.visitor;
import persistence.*;

public interface ModuleAbstractStudentExceptionVisitor<E extends model.UserException> {
    
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException, E;
    public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException, E;
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException, E;
    
}
