package view;

import view.objects.*;

import view.visitor.*;

public interface ClipBoardStateView extends Anything, AbstractViewRoot {
    
    
    public void accept(ClipBoardStateVisitor visitor) throws ModelException;
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

