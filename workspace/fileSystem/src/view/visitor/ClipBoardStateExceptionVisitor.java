
package view.visitor;

import view.*;

public interface ClipBoardStateExceptionVisitor<E extends view.UserException> {
    
    public void handleEmptyCBState(EmptyCBStateView emptyCBState) throws ModelException, E;
    public void handleFilledCBState(FilledCBStateView filledCBState) throws ModelException, E;
    
}
