
package model.visitor;

import persistence.*;

public interface ClipBoardStateExceptionVisitor<E extends model.UserException> {
    
    public void handleEmptyCBState(EmptyCBState4Public emptyCBState) throws PersistenceException, E;
    public void handleFilledCBState(FilledCBState4Public filledCBState) throws PersistenceException, E;
    
}
