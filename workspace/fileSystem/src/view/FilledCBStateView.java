package view;

import view.visitor.*;

public interface FilledCBStateView extends ClipBoardStateView {
    
    public ContaineeView getContents()throws ModelException;
    public void setContents(ContaineeView newValue) throws ModelException ;
    
    public void accept(ClipBoardStateVisitor visitor) throws ModelException;
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

