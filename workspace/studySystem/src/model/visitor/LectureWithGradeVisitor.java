
package model.visitor;
import persistence.*;

public interface LectureWithGradeVisitor {
    
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException;
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    
}
