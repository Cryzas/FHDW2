
package model.visitor;
import persistence.*;

public interface programHierarchySGroupHIERARCHYVisitor extends ModuleAbstractSGroupVisitor{
    
    public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    
}
