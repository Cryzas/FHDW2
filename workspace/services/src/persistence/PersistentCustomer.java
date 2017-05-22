package persistence;


public interface PersistentCustomer extends PersistentService, Customer4Public {
    
    public PersistentCustomer getThis() throws PersistenceException ;
    
    

}

