package persistence;


public interface PersistentAccountWrapper extends PersistentabstractAcc, AccountWrapper4Public {
    
    public Account4Public getWrapped() throws PersistenceException ;
    public void setWrapped(Account4Public newValue) throws PersistenceException ;
    public PersistentAccountWrapper getThis() throws PersistenceException ;
    
    

}

