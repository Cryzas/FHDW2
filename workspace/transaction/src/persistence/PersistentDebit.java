package persistence;


public interface PersistentDebit extends PersistentEntry, Debit4Public {
    
    public PersistentDebit getThis() throws PersistenceException ;
    
    

}

