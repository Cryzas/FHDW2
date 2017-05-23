package view;

import view.objects.*;

import view.visitor.*;

public interface MailView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<AccountWrapperView> getReceivers()throws ModelException;
    public void setReceivers(java.util.Vector<AccountWrapperView> newValue) throws ModelException ;
    public String getSubject()throws ModelException;
    public void setSubject(String newValue) throws ModelException ;
    public String getText()throws ModelException;
    public void setText(String newValue) throws ModelException ;
    
    public void accept(MailVisitor visitor) throws ModelException;
    public <R> R accept(MailReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MailExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

