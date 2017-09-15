
package model.visitor;

import persistence.*;

public abstract class LectureWithGradeStandardVisitor implements LectureWithGradeVisitor {
    
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException{
        this.standardHandling(unitStudent);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException{
        this.standardHandling(moduleAtomarStudent);
    }
    protected abstract void standardHandling(LectureWithGrade lectureWithGrade) throws PersistenceException;
}
