
package model.visitor;

import persistence.*;

public interface TransferManagerCommandReturnVisitor<R> {
    
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    
}
