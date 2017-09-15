
package view.visitor;
import view.*;

public interface ModuleAbstractStudentVisitor {
    
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException;
    public void handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException;
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent) throws ModelException;
    
}
