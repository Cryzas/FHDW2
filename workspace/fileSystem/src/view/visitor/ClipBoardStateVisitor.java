
package view.visitor;

import view.*;

public interface ClipBoardStateVisitor {
    
    public void handleEmptyCBState(EmptyCBStateView emptyCBState) throws ModelException;
    public void handleFilledCBState(FilledCBStateView filledCBState) throws ModelException;
    
}
