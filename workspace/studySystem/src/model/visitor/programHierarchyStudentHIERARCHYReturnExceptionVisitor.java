
package model.visitor;
import persistence.*;

public interface programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E extends model.UserException> extends ModuleAbstractStudentReturnExceptionVisitor<R, E> ,ProgramStudentReturnExceptionVisitor<R, E> {
    
    public R handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException, E;
    public R handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException, E;
    
}
