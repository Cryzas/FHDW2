
package view.visitor;

import view.*;

public abstract class ProgramStudentStandardVisitor implements ProgramStudentVisitor {
    
    public void handleNoProgram(NoProgramView noProgram) throws ModelException{
        this.standardHandling(noProgram);
    }
    public void handleProgramStudent(ProgramStudentView programStudent) throws ModelException{
        this.standardHandling(programStudent);
    }
    protected abstract void standardHandling(ProgramStudentView programStudent) throws ModelException;
}
