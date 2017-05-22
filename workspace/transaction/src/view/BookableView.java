package view;

import view.objects.*;

import view.visitor.*;

public interface BookableView extends Anything, AbstractViewRoot {
    
    public String getSubject()throws ModelException;
    public void setSubject(String newValue) throws ModelException ;
    
    public void accept(BookableVisitor visitor) throws ModelException;
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

