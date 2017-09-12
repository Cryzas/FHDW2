
package model.visitor;

import persistence.*;

public abstract class programHierarchyStudentHIERARCHYStandardVisitor implements programHierarchyStudentHIERARCHYVisitor {
    
    public void handleNoProgram(NoProgram4Public noProgram) throws PersistenceException{
        this.standardHandling(noProgram);
    }
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException{
        this.standardHandling(moduleWithUnitsStudent);
    }
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException{
        this.standardHandling(unitStudent);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException{
        this.standardHandling(moduleAtomarStudent);
    }
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException{
        this.standardHandling(programStudent);
    }
    public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException{
        this.standardHandling(moduleGroupStudent);
    }
    protected abstract void standardHandling(programHierarchyStudentHIERARCHY programHierarchyStudentHIERARCHY) throws PersistenceException;
}
