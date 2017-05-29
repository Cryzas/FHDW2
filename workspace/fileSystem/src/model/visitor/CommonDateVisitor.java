
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException;
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException;
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
