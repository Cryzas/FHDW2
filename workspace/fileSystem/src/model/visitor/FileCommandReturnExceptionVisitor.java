
package model.visitor;

import persistence.*;

public interface FileCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException, E;
    
}
