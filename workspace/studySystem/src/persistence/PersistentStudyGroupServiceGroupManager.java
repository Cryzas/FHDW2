package persistence;


public interface PersistentStudyGroupServiceGroupManager extends Anything, ObsInterface, AbstractPersistentProxi, StudyGroupServiceGroupManager4Public {
    
    public StudyGroupService4Public getObserver() throws PersistenceException ;
    public void setObserver(StudyGroupService4Public newValue) throws PersistenceException ;
    public StudyGroupManager4Public getObservee() throws PersistenceException ;
    public void setObservee(StudyGroupManager4Public newValue) throws PersistenceException ;
    public PersistentStudyGroupServiceGroupManager getThis() throws PersistenceException ;
    
    

}

