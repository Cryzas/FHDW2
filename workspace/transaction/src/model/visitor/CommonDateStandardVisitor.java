
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleRemoveTransferCommand(RemoveTransferCommand4Public removeTransferCommand) throws PersistenceException{
        this.standardHandling(removeTransferCommand);
    }
    public void handleCreateTransactionCommand(CreateTransactionCommand4Public createTransactionCommand) throws PersistenceException{
        this.standardHandling(createTransactionCommand);
    }
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException{
        this.standardHandling(bookCommand);
    }
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException{
        this.standardHandling(createTransferCommand);
    }
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleAddTransferCommand(AddTransferCommand4Public addTransferCommand) throws PersistenceException{
        this.standardHandling(addTransferCommand);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
