
package view.visitor;
import view.*;

public interface LectureWithGradeVisitor {
    
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException;
    public void handleUnitStudent(UnitStudentView unitStudent) throws ModelException;
    
}
