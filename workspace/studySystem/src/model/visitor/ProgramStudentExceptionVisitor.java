
package model.visitor;
import persistence.*;

public interface ProgramStudentExceptionVisitor<E extends model.UserException> {
    
    public void handleNoProgram(NoProgram4Public noProgram) throws PersistenceException, E;
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException, E;
    
}
