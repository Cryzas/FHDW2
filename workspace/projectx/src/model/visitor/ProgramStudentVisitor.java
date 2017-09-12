
package model.visitor;
import persistence.*;

public interface ProgramStudentVisitor {
    
    public void handleNoProgram(NoProgram4Public noProgram) throws PersistenceException;
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    
}
