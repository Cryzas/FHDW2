
package view.visitor;
import view.*;

public interface ModuleAbstractStudentExceptionVisitor<E extends view.UserException> {
    
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException, E;
    public void handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException, E;
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent) throws ModelException, E;
    
}
