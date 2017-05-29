
package view.visitor;

import view.*;

public interface ClipBoardStateReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleEmptyCBState(EmptyCBStateView emptyCBState) throws ModelException, E;
    public R handleFilledCBState(FilledCBStateView filledCBState) throws ModelException, E;
    
}
