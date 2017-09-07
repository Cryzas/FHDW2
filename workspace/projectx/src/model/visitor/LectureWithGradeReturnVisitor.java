
package model.visitor;
import persistence.*;

public interface LectureWithGradeReturnVisitor<R> {
    
    public R handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException;
    public R handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    
}
