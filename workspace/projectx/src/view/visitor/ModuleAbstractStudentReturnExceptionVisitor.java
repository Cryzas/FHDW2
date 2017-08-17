
package view.visitor;
import view.*;

public interface ModuleAbstractStudentReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException, E;
    public R handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException, E;
    public R handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent) throws ModelException, E;
    
}
