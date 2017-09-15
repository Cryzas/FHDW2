package persistence;


public interface PersistentStudyGroup extends Anything, AbstractPersistentProxi, StudyGroup4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException ;
    public PersistentStudyGroup getThis() throws PersistenceException ;
    
    

}

