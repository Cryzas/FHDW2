package view;

import view.visitor.*;

public interface AccountWrapperView extends abstractAccView {
    
    
    public void accept(abstractAccVisitor visitor) throws ModelException;
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

