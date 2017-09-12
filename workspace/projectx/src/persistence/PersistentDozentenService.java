package persistence;


public interface PersistentDozentenService extends PersistentService, DozentenService4Public {
    
    public void setProgramManager(ProgramManager4Public newValue) throws PersistenceException ;
    public void setModuleManager(ModuleManager4Public newValue) throws PersistenceException ;
    public void setGroupManager(StudyGroupManager4Public newValue) throws PersistenceException ;
    public void setStudentManager(StudentManager4Public newValue) throws PersistenceException ;
    public PersistentDozentenService getThis() throws PersistenceException ;
    
    

}

