
package model.visitor;

import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException, E;
    public R handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException, E;
    public R handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    
}
