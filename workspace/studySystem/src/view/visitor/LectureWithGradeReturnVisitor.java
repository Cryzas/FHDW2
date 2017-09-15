
package view.visitor;
import view.*;

public interface LectureWithGradeReturnVisitor<R> {
    
    public R handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException;
    public R handleUnitStudent(UnitStudentView unitStudent) throws ModelException;
    
}
