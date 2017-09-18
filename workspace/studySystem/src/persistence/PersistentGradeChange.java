package persistence;


public interface PersistentGradeChange extends Anything, SubjInterface, AbstractPersistentProxi, GradeChange4Public {
    
    public void setFromGrade(Grade4Public newValue) throws PersistenceException ;
    public void setToGrade(Grade4Public newValue) throws PersistenceException ;
    public void setDateOfChange(java.sql.Date newValue) throws PersistenceException ;
    public void setComment(String newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentGradeChange getThis() throws PersistenceException ;
    
    

}

