
package model.visitor;

import persistence.*;

public interface FileCommandReturnVisitor<R> {
    
    public R handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException;
    
}
