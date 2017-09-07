package persistence;


public interface PersistentGrade extends Anything, AbstractPersistentProxi, Grade4Public {
    
    public abstract PersistentGrade getThis() throws PersistenceException ;
    
    

}

