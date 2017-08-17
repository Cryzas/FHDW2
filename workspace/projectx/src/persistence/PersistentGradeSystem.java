package persistence;


public interface PersistentGradeSystem extends Anything, AbstractPersistentProxi, GradeSystem4Public {
    
    public abstract PersistentGradeSystem getThis() throws PersistenceException ;
    
    

}

