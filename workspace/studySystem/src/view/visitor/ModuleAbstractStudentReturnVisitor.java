
package view.visitor;
import view.*;

public interface ModuleAbstractStudentReturnVisitor<R> {
    
    public R handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException;
    public R handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException;
    public R handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent) throws ModelException;
    
}
