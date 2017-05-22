
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddTransferCommand(AddTransferCommand4Public addTransferCommand) throws PersistenceException;
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public void handleCreateTransactionCommand(CreateTransactionCommand4Public createTransactionCommand) throws PersistenceException;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    public void handleRemoveTransferCommand(RemoveTransferCommand4Public removeTransferCommand) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
