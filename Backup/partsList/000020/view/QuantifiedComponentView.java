package view;

import view.objects.*;

import view.visitor.*;

public interface QuantifiedComponentView extends Anything, AbstractViewRoot {
    
    public long getQuantity()throws ModelException;
    public void setQuantity(long newValue) throws ModelException ;
    public ComponentView getComponent()throws ModelException;
    public void setComponent(ComponentView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

