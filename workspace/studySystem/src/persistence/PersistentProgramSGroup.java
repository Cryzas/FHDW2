package persistence;


public interface PersistentProgramSGroup extends programHierarchySGroupHIERARCHY, Anything, SubjInterface, AbstractPersistentProxi, ProgramSGroup4Public {
    
    public Program4Public getProgramCopy() throws PersistenceException ;
    public void setProgramCopy(Program4Public newValue) throws PersistenceException ;
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentProgramSGroup getThis() throws PersistenceException ;
    
    

}

