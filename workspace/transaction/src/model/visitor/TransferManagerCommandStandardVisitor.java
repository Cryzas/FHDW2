
package model.visitor;

import persistence.*;

public abstract class TransferManagerCommandStandardVisitor implements TransferManagerCommandVisitor {
    
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException{
        this.standardHandling(bookCommand);
    }
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException{
        this.standardHandling(createTransferCommand);
    }
    protected abstract void standardHandling(TransferManagerCommand transferManagerCommand) throws PersistenceException;
}
