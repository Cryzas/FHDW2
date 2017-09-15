package persistence;


public interface PersistentGradeChange extends Anything, AbstractPersistentProxi, GradeChange4Public {
    
    public void setFromGrade(Grade4Public newValue) throws PersistenceException ;
    public void setToGrade(Grade4Public newValue) throws PersistenceException ;
    public void setDateOfChange(java.sql.Date newValue) throws PersistenceException ;
    public void setComment(String newValue) throws PersistenceException ;
    public PersistentGradeChange getThis() throws PersistenceException ;
    
    

}

