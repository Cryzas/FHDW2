package view;

import view.objects.*;

import view.visitor.*;

public interface MyBooleanView extends Anything, AbstractViewRoot {
    
    
    public void accept(MyBooleanVisitor visitor) throws ModelException;
    public <R> R accept(MyBooleanReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MyBooleanExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MyBooleanReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

