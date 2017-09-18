package persistence;


public interface PersistentStudyGroupService extends PersistentsubAdminService, StudyGroupService4Public {
    
    public void setGroupManager(StudyGroupServiceGroupManager4Public newValue) throws PersistenceException ;
    public PersistentStudyGroupService getThis() throws PersistenceException ;
    
    
    public void setGroupManager(final StudyGroupManager4Public groupManager) 
				throws PersistenceException;
    public StudentSearchList getStudents() 
				throws PersistenceException;
    public void groupManager_update(final model.meta.StudyGroupManagerMssgs event) 
				throws PersistenceException;

}

