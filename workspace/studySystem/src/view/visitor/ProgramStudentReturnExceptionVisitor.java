
package view.visitor;
import view.*;

public interface ProgramStudentReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleNoProgram(NoProgramView noProgram) throws ModelException, E;
    public R handleProgramStudent(ProgramStudentView programStudent) throws ModelException, E;
    
}
