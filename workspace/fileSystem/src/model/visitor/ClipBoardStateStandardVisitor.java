
package model.visitor;

import persistence.*;

public abstract class ClipBoardStateStandardVisitor implements ClipBoardStateVisitor {
    
    public void handleFilledCBState(FilledCBState4Public filledCBState) throws PersistenceException{
        this.standardHandling(filledCBState);
    }
    public void handleEmptyCBState(EmptyCBState4Public emptyCBState) throws PersistenceException{
        this.standardHandling(emptyCBState);
    }
    protected abstract void standardHandling(ClipBoardState4Public clipBoardState) throws PersistenceException;
}
