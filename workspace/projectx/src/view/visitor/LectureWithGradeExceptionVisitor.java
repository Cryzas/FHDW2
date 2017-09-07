
package view.visitor;
import view.*;

public interface LectureWithGradeExceptionVisitor<E extends view.UserException> {
    
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException, E;
    public void handleUnitStudent(UnitStudentView unitStudent) throws ModelException, E;
    
}
