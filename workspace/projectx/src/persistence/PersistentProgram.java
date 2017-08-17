package persistence;


public interface PersistentProgram extends Anything, programHierarchyHIERARCHY, AbstractPersistentProxi, Program4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setGradeSystem(GradeSystem4Public newValue) throws PersistenceException ;
    public PersistentProgram getThis() throws PersistenceException ;
    
    

}

