
package model.visitor;
import persistence.*;

public interface programHierarchySGroupHIERARCHYExceptionVisitor<E extends model.UserException> extends ModuleAbstractSGroupExceptionVisitor<E>{
    
    public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException, E;
    public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException, E;
    
}
