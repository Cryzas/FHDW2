
package view.visitor;

import view.*;

public interface ClipBoardStateReturnVisitor<R> {
    
    public R handleEmptyCBState(EmptyCBStateView emptyCBState) throws ModelException;
    public R handleFilledCBState(FilledCBStateView filledCBState) throws ModelException;
    
}
