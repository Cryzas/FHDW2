package persistence;


public interface PersistentRegister extends PersistentService, Register4Public {
    
    public PersistentRegister getThis() throws PersistenceException ;
    
    

}

