
package model.visitor;
import persistence.*;

public interface ProgramManagerCommandReturnVisitor<R> {
    
    public R handleAddModuleCommand(AddModuleCommand4Public addModuleCommand) throws PersistenceException;
    public R handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException;
    
}
