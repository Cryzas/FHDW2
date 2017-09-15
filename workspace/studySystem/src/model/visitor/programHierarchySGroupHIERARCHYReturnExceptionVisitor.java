
package model.visitor;
import persistence.*;

public interface programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E extends model.UserException> extends ModuleAbstractSGroupReturnExceptionVisitor<R, E> {
    
    public R handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException, E;
    public R handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException, E;
    
}
