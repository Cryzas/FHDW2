
package model.visitor;
import persistence.*;

public interface ProgramManagerCommandVisitor {
    
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException;
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException;
    
}
