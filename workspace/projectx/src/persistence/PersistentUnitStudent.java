package persistence;


public interface PersistentUnitStudent extends Anything, programHierarchyStudentHIERARCHY, AbstractPersistentProxi, UnitStudent4Public {
    
    public UnitSGroup4Public getUnitCopy() throws PersistenceException ;
    public void setUnitCopy(UnitSGroup4Public newValue) throws PersistenceException ;
    public void setGrade(GradesInThird4Public newValue) throws PersistenceException ;
    public PersistentUnitStudent getThis() throws PersistenceException ;
    
    

}

