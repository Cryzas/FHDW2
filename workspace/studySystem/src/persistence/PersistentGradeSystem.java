package persistence;


public interface PersistentGradeSystem extends Anything, SubjInterface, AbstractPersistentProxi, GradeSystem4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentGradeSystem getThis() throws PersistenceException ;
    
    

}

