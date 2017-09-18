package view;

import view.visitor.*;

public interface NoAccountView extends AccountView {
    
    
    public void accept(AccountVisitor visitor) throws ModelException;
    public <R> R accept(AccountReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AccountExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AccountReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AccountHandleVisitor visitor) throws ModelException;
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

