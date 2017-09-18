package persistence;


public interface PersistentGrade extends Anything, SubjInterface, AbstractPersistentProxi, Grade4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentGrade getThis() throws PersistenceException ;
    
    

}

