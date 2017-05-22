
package model.visitor;

import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleAddTransferCommand(AddTransferCommand4Public addTransferCommand) throws PersistenceException;
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public R handleCreateTransactionCommand(CreateTransactionCommand4Public createTransactionCommand) throws PersistenceException;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    public R handleRemoveTransferCommand(RemoveTransferCommand4Public removeTransferCommand) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
