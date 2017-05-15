package persistence;


public interface PersistentAccountWrppr extends PersistentAccountHandle, AccountWrppr4Public {
    
    public void setAccount(Account4Public newValue) throws PersistenceException ;
    public PersistentAccountWrppr getThis() throws PersistenceException ;
    
    

}

