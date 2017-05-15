package view;

import view.objects.*;

import view.visitor.*;

public interface AccountHandleView extends Anything, AbstractViewRoot {
    
    
    public void accept(AccountHandleVisitor visitor) throws ModelException;
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

