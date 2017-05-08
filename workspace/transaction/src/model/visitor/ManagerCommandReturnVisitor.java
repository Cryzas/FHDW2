
package model.visitor;

import persistence.*;

public interface ManagerCommandReturnVisitor<R> {
    
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    
}
