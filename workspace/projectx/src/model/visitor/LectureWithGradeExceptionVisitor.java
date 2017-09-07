
package model.visitor;
import persistence.*;

public interface LectureWithGradeExceptionVisitor<E extends model.UserException> {
    
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException, E;
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException, E;
    
}
