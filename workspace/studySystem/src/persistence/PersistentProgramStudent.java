package persistence;


public interface PersistentProgramStudent extends Anything, programHierarchyStudentHIERARCHY, SubjInterface, AbstractPersistentProxi, ProgramStudent4Public {
    
    public void setProgramCopy(ProgramSGroup4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentProgramStudent getThis() throws PersistenceException ;
    
    

}

