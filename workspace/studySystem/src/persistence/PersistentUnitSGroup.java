package persistence;


public interface PersistentUnitSGroup extends programHierarchySGroupHIERARCHY, Anything, AbstractPersistentProxi, UnitSGroup4Public {
    
    public Unit4Public getUnitCopy() throws PersistenceException ;
    public void setUnitCopy(Unit4Public newValue) throws PersistenceException ;
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException ;
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException ;
    public PersistentUnitSGroup getThis() throws PersistenceException ;
    
    

}

