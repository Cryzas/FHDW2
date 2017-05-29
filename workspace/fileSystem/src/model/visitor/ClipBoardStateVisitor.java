
package model.visitor;

import persistence.*;

public interface ClipBoardStateVisitor {
    
    public void handleEmptyCBState(EmptyCBState4Public emptyCBState) throws PersistenceException;
    public void handleFilledCBState(FilledCBState4Public filledCBState) throws PersistenceException;
    
}
