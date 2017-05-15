
package model.visitor;

import persistence.*;

public interface TransferManagerCommandVisitor {
    
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    
}
