package view;

import view.visitor.*;

public interface MailEntryView extends MailView {
    
    public AccountWrapperView getSender()throws ModelException;
    public void setSender(AccountWrapperView newValue) throws ModelException ;
    
    public void accept(MailVisitor visitor) throws ModelException;
    public <R> R accept(MailReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(MailExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

