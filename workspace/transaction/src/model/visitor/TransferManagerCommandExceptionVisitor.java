
package model.visitor;
import persistence.*;

public interface TransferManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException, E;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException, E;
    
}
