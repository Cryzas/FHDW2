package persistence;


public interface PersistentProgramSGroup extends programHierarchySGroupHIERARCHY, Anything, AbstractPersistentProxi, ProgramSGroup4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public PersistentProgramSGroup getThis() throws PersistenceException ;
    
    

}

