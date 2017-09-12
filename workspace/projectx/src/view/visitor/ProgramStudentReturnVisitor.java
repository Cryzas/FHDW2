
package view.visitor;
import view.*;

public interface ProgramStudentReturnVisitor<R> {
    
    public R handleNoProgram(NoProgramView noProgram) throws ModelException;
    public R handleProgramStudent(ProgramStudentView programStudent) throws ModelException;
    
}
