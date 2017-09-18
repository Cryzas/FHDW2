package persistence;


public interface PersistentBooked extends PersistentTransferState, Booked4Public {
    
    public PersistentBooked getThis() throws PersistenceException ;
    
    

}

