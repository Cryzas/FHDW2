
package model.visitor;
import persistence.*;

public interface ProgramManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleAddModuleCommand(AddModuleCommand4Public addModuleCommand) throws PersistenceException, E;
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException, E;
    
}
