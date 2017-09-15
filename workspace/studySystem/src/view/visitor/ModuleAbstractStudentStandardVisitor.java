
package view.visitor;

import view.*;

public abstract class ModuleAbstractStudentStandardVisitor implements ModuleAbstractStudentVisitor {
    
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent) throws ModelException{
        this.standardHandling(moduleWithUnitsStudent);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException{
        this.standardHandling(moduleAtomarStudent);
    }
    public void handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException{
        this.standardHandling(moduleGroupStudent);
    }
    protected abstract void standardHandling(ModuleAbstractStudentView moduleAbstractStudent) throws ModelException;
}
