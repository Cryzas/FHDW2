package persistence;


public interface PersistentUnit extends Anything, programHierarchyHIERARCHY, AbstractPersistentProxi, Unit4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException ;
    public PersistentUnit getThis() throws PersistenceException ;
    
    

}

