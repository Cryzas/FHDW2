
package view.visitor;

import view.*;

public abstract class LectureWithGradeStandardVisitor implements LectureWithGradeVisitor {
    
    public void handleUnitStudent(UnitStudentView unitStudent) throws ModelException{
        this.standardHandling(unitStudent);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException{
        this.standardHandling(moduleAtomarStudent);
    }
    protected abstract void standardHandling(LectureWithGrade lectureWithGrade) throws ModelException;
}
