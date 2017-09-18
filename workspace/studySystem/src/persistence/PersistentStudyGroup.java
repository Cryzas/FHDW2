package persistence;


public interface PersistentStudyGroup extends Anything, SubjInterface, AbstractPersistentProxi, StudyGroup4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentStudyGroup getThis() throws PersistenceException ;
    
    

}

