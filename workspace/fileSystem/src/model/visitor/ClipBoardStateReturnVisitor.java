
package model.visitor;

import persistence.*;

public interface ClipBoardStateReturnVisitor<R> {
    
    public R handleEmptyCBState(EmptyCBState4Public emptyCBState) throws PersistenceException;
    public R handleFilledCBState(FilledCBState4Public filledCBState) throws PersistenceException;
    
}
