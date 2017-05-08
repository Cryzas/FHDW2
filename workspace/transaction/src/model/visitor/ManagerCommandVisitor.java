
package model.visitor;

import persistence.*;

public interface ManagerCommandVisitor {
    
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    
}
