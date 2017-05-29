
package model.visitor;

import persistence.*;

public interface ClipBoardStateReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleEmptyCBState(EmptyCBState4Public emptyCBState) throws PersistenceException, E;
    public R handleFilledCBState(FilledCBState4Public filledCBState) throws PersistenceException, E;
    
}
