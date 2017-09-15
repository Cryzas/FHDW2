package view;

import view.visitor.*;

public interface BTrueView extends MyBooleanView {
    
    
    public void accept(MyBooleanVisitor visitor) throws ModelException;
    public <R> R accept(MyBooleanReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MyBooleanExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MyBooleanReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

