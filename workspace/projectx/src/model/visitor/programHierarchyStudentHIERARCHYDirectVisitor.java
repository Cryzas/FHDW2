
package model.visitor;

import persistence.*;

public abstract class programHierarchyStudentHIERARCHYDirectVisitor implements programHierarchyStudentHIERARCHYVisitor {
    
    public abstract void handleModuleAbstractStudent(ModuleAbstractStudent4Public moduleAbstractStudent) throws PersistenceException;
    
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException{
        this.handleModuleAbstractStudent(moduleWithUnitsStudent);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException{
        this.handleModuleAbstractStudent(moduleAtomarStudent);
    }
    public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException{
        this.handleModuleAbstractStudent(moduleGroupStudent);
    }
    public abstract void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    
    public abstract void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    
    public void handleNoProgram(NoProgram4Public noProgram) throws PersistenceException{
        this.handleProgramStudent(noProgram);
    }
    
}
