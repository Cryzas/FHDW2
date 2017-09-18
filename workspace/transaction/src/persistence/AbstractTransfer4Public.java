package persistence;


import model.visitor.*;

public interface AbstractTransfer4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    public String getSubject() throws PersistenceException ;
    public TransferState4Public getState() throws PersistenceException ;
    
    public void accept(AbstractTransferVisitor visitor) throws PersistenceException;
    public <R> R accept(AbstractTransferReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AbstractTransferExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AbstractTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void book() 
				throws model.TransferException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void doBooking() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

