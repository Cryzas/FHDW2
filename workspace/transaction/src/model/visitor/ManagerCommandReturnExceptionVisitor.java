
package model.visitor;

import persistence.*;

public interface ManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException, E;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException, E;
    
}
