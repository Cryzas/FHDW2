package persistence;


public interface PersistentUnitSGroup extends programHierarchySGroupHIERARCHY, Anything, AbstractPersistentProxi, UnitSGroup4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException ;
    public PersistentUnitSGroup getThis() throws PersistenceException ;
    
    

}

