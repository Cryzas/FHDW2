package view;

import view.objects.*;

import view.visitor.*;

public interface abstractAccView extends Anything, AbstractViewRoot {
    
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    
    public void accept(abstractAccVisitor visitor) throws ModelException;
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

