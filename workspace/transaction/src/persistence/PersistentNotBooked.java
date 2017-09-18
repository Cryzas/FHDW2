package persistence;


public interface PersistentNotBooked extends PersistentTransferState, NotBooked4Public {
    
    public PersistentNotBooked getThis() throws PersistenceException ;
    
    

}

