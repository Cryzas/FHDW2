package persistence;


public interface PersistentTransferManager extends Anything, SubjInterface, AbstractPersistentProxi, TransferManager4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentTransferManager getThis() throws PersistenceException ;
    
    

}

