
package view.visitor;

import view.*;

public abstract class ClipBoardStateStandardVisitor implements ClipBoardStateVisitor {
    
    public void handleFilledCBState(FilledCBStateView filledCBState) throws ModelException{
        this.standardHandling(filledCBState);
    }
    public void handleEmptyCBState(EmptyCBStateView emptyCBState) throws ModelException{
        this.standardHandling(emptyCBState);
    }
    protected abstract void standardHandling(ClipBoardStateView clipBoardState) throws ModelException;
}
