package persistence;


import model.visitor.*;

public interface abstractAcc4Public extends Anything, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    
    public void accept(abstractAccVisitor visitor) throws PersistenceException;
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createDraft(final String subject, final String text) 
				throws PersistenceException;
    public void createFolder(final String name) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void receive(final MailEntry4Public mail) 
				throws PersistenceException;
    public void send(final Draft4Public draft) 
				throws PersistenceException;

}

