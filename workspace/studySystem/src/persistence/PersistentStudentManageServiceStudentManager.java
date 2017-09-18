package persistence;


public interface PersistentStudentManageServiceStudentManager extends Anything, ObsInterface, AbstractPersistentProxi, StudentManageServiceStudentManager4Public {
    
    public StudentManageService4Public getObserver() throws PersistenceException ;
    public void setObserver(StudentManageService4Public newValue) throws PersistenceException ;
    public StudentManager4Public getObservee() throws PersistenceException ;
    public void setObservee(StudentManager4Public newValue) throws PersistenceException ;
    public PersistentStudentManageServiceStudentManager getThis() throws PersistenceException ;
    
    

}

