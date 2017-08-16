
package model.visitor;
import persistence.*;

public interface programHierarchyHIERARCHYExceptionVisitor<E extends model.UserException> extends ModuleAbstractExceptionVisitor<E>{
    
    public void handleProgram(Program4Public program) throws PersistenceException, E;
    public void handleUnit(Unit4Public unit) throws PersistenceException, E;
    
}
