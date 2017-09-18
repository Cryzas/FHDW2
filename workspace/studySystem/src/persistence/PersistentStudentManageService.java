package persistence;


public interface PersistentStudentManageService extends PersistentsubAdminService, StudentManageService4Public {
    
    public void setStudentManager(StudentManageServiceStudentManager4Public newValue) throws PersistenceException ;
    public PersistentStudentManageService getThis() throws PersistenceException ;
    
    
    public void setStudentManager(final StudentManager4Public studentManager) 
				throws PersistenceException;
    public void studentManager_update(final model.meta.StudentManagerMssgs event) 
				throws PersistenceException;

}

