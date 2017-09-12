
package model.visitor;

import persistence.*;

public abstract class ProgramStudentStandardVisitor implements ProgramStudentVisitor {
    
    public void handleNoProgram(NoProgram4Public noProgram) throws PersistenceException{
        this.standardHandling(noProgram);
    }
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException{
        this.standardHandling(programStudent);
    }
    protected abstract void standardHandling(ProgramStudent4Public programStudent) throws PersistenceException;
}
