
package view.visitor;
import view.*;

public interface ProgramStudentVisitor {
    
    public void handleNoProgram(NoProgramView noProgram) throws ModelException;
    public void handleProgramStudent(ProgramStudentView programStudent) throws ModelException;
    
}
