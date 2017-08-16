
package model.visitor;
import persistence.*;

public interface programHierarchyHIERARCHYVisitor extends ModuleAbstractVisitor{
    
    public void handleProgram(Program4Public program) throws PersistenceException;
    public void handleUnit(Unit4Public unit) throws PersistenceException;
    
}
