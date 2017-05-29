
package model.visitor;

import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException;
    public R handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException;
    public R handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
