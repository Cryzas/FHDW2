
package model.visitor;
import persistence.*;

public interface ProgramManagerCommandVisitor {
    
    public void handleAddModuleCommand(AddModuleCommand4Public addModuleCommand) throws PersistenceException;
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException;
    
}
