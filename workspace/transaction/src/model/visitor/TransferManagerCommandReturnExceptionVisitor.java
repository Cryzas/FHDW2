
package model.visitor;

import persistence.*;

public interface TransferManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddTransferCommand(AddTransferCommand4Public addTransferCommand) throws PersistenceException, E;
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException, E;
    public R handleCreateTransactionCommand(CreateTransactionCommand4Public createTransactionCommand) throws PersistenceException, E;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException, E;
    public R handleRemoveTransferCommand(RemoveTransferCommand4Public removeTransferCommand) throws PersistenceException, E;
    
}
