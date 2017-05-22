
package model.visitor;

import persistence.*;

public interface TransferManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleAddTransferCommand(AddTransferCommand4Public addTransferCommand) throws PersistenceException, E;
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException, E;
    public void handleCreateTransactionCommand(CreateTransactionCommand4Public createTransactionCommand) throws PersistenceException, E;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException, E;
    public void handleRemoveTransferCommand(RemoveTransferCommand4Public removeTransferCommand) throws PersistenceException, E;
    
}
