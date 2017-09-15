package persistence;


public interface PersistentCommonDate extends Anything, AbstractPersistentProxi, CommonDate4Public {
    
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException ;
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException ;
    
    

}

