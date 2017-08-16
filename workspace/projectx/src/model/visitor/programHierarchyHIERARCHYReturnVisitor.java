
package model.visitor;
import persistence.*;

public interface programHierarchyHIERARCHYReturnVisitor<R> extends ModuleAbstractReturnVisitor<R> {
    
    public R handleProgram(Program4Public program) throws PersistenceException;
    public R handleUnit(Unit4Public unit) throws PersistenceException;
    
}
