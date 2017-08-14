
package model.visitor;
import persistence.*;

public interface ProgramManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddModuleCommand(AddModuleCommand4Public addModuleCommand) throws PersistenceException, E;
    public R handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException, E;
    
}
