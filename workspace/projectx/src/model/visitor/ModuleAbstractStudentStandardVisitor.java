
package model.visitor;

import persistence.*;

public abstract class ModuleAbstractStudentStandardVisitor implements ModuleAbstractStudentVisitor {
    
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException{
        this.standardHandling(moduleWithUnitsStudent);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException{
        this.standardHandling(moduleAtomarStudent);
    }
    public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException{
        this.standardHandling(moduleGroupStudent);
    }
    protected abstract void standardHandling(ModuleAbstractStudent4Public moduleAbstractStudent) throws PersistenceException;
}
