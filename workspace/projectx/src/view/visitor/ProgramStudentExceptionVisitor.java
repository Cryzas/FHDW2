
package view.visitor;
import view.*;

public interface ProgramStudentExceptionVisitor<E extends view.UserException> {
    
    public void handleNoProgram(NoProgramView noProgram) throws ModelException, E;
    public void handleProgramStudent(ProgramStudentView programStudent) throws ModelException, E;
    
}
