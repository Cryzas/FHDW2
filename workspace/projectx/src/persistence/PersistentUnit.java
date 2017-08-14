package persistence;


public interface PersistentUnit extends Anything, SubjInterface, AbstractPersistentProxi, Unit4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentUnit getThis() throws PersistenceException ;
    
    
    public ModuleWithUnitsSearchList getParentModule() 
				throws PersistenceException;

}

