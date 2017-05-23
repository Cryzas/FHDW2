package persistence;


import model.visitor.*;

public interface Mail4Public extends Anything, AbstractPersistentProxi {
    
    public Mail_ReceiversProxi getReceivers() throws PersistenceException ;
    public String getSubject() throws PersistenceException ;
    public String getText() throws PersistenceException ;
    
    public void accept(MailVisitor visitor) throws PersistenceException;
    public <R> R accept(MailReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(MailExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

