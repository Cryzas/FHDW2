
package model.visitor;
import persistence.*;

public interface programHierarchyHIERARCHYReturnExceptionVisitor<R, E extends model.UserException> extends ModuleAbstractReturnExceptionVisitor<R, E> {
    
    public R handleProgram(Program4Public program) throws PersistenceException, E;
    public R handleUnit(Unit4Public unit) throws PersistenceException, E;
    
}
