
package model.visitor;
import persistence.*;

public interface programHierarchyStudentHIERARCHYVisitor extends ModuleAbstractStudentVisitor{
    
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    
}
