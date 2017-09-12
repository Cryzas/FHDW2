
package model.visitor;
import persistence.*;

public interface ProgramStudentReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleNoProgram(NoProgram4Public noProgram) throws PersistenceException, E;
    public R handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException, E;
    
}
