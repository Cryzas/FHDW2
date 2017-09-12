
package model.visitor;
import persistence.*;

public interface ProgramStudentReturnVisitor<R> {
    
    public R handleNoProgram(NoProgram4Public noProgram) throws PersistenceException;
    public R handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    
}
