package view;

import viewClient.*;

import view.objects.*;

import view.visitor.*;

public interface ServiceView extends Anything, Remote, AbstractViewRoot {
    
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException;
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException ;
    
    public void accept(ServiceVisitor visitor) throws ModelException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public ServiceConnection connectService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

