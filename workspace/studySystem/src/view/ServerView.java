package view;

import viewClient.*;

import view.objects.*;

import view.visitor.*;

public interface ServerView extends Anything, Remote, AbstractViewRoot {
    
    public ServiceView getService()throws ModelException;
    public void setService(ServiceView newValue) throws ModelException ;
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException;
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException ;
    public String getUser()throws ModelException;
    public void setUser(String newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(RemoteVisitor visitor) throws ModelException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public ServerConnection connectServer(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

