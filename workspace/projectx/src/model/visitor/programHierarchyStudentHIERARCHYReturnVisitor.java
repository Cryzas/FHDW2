
package model.visitor;
import persistence.*;

public interface programHierarchyStudentHIERARCHYReturnVisitor<R> extends ModuleAbstractStudentReturnVisitor<R> {
    
    public R handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    public R handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    
}
