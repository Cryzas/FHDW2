
package model.visitor;

import persistence.*;

public interface ManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException, E;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException, E;
    
}
