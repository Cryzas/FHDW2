
package view.visitor;
import view.*;

public interface LectureWithGradeReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException, E;
    public R handleUnitStudent(UnitStudentView unitStudent) throws ModelException, E;
    
}
