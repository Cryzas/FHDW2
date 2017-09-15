
package model.visitor;
import persistence.*;

public interface LectureWithGradeReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException, E;
    public R handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException, E;
    
}
