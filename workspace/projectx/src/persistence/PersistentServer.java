package persistence;


public interface PersistentServer extends Invoker, Anything, Remote, AbstractPersistentProxi, Server4Public {
    
    public void setProgramManager(ProgramManager4Public newValue) throws PersistenceException ;
    public void setModuleManager(ModuleManager4Public newValue) throws PersistenceException ;
    public void setGroupManager(StudyGroupManager4Public newValue) throws PersistenceException ;
    public void setStudentManager(StudentManager4Public newValue) throws PersistenceException ;
    public Server_ErrorsProxi getErrors() throws PersistenceException ;
    public String getPassword() throws PersistenceException ;
    public void setPassword(String newValue) throws PersistenceException ;
    public void setUser(String newValue) throws PersistenceException ;
    public long getHackCount() throws PersistenceException ;
    public void setHackCount(long newValue) throws PersistenceException ;
    public java.sql.Timestamp getHackDelay() throws PersistenceException ;
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException ;
    public PersistentServer getThis() throws PersistenceException ;
    
    

}

