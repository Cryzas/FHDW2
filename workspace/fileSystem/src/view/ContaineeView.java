package view;

import view.objects.*;

import view.visitor.*;

public interface ContaineeView extends Anything, AbstractViewRoot {
    
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    
    public void accept(ContaineeVisitor visitor) throws ModelException;
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

