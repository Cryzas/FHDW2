
package model.visitor;
import persistence.*;

public interface programHierarchyStudentHIERARCHYExceptionVisitor<E extends model.UserException> extends ModuleAbstractStudentExceptionVisitor<E>{
    
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException, E;
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException, E;
    
}
