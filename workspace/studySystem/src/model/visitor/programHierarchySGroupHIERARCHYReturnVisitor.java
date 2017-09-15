
package model.visitor;
import persistence.*;

public interface programHierarchySGroupHIERARCHYReturnVisitor<R> extends ModuleAbstractSGroupReturnVisitor<R> {
    
    public R handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public R handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    
}
