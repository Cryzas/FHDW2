package persistence;


public interface PersistentProgramStudent extends Anything, programHierarchyStudentHIERARCHY, AbstractPersistentProxi, ProgramStudent4Public {
    
    public ProgramSGroup4Public getProgramCopy() throws PersistenceException ;
    public void setProgramCopy(ProgramSGroup4Public newValue) throws PersistenceException ;
    public PersistentProgramStudent getThis() throws PersistenceException ;
    
    

}

