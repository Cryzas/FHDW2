package persistence;


public interface PersistentStudyGroupManager extends Anything, SubjInterface, AbstractPersistentProxi, StudyGroupManager4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentStudyGroupManager getThis() throws PersistenceException ;
    
    

}

