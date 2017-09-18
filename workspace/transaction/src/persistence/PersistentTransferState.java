package persistence;


public interface PersistentTransferState extends Anything, SubjInterface, AbstractPersistentProxi, TransferState4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentTransferState getThis() throws PersistenceException ;
    
    

}

