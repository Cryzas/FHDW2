package persistence;


public interface PersistentProgramManager extends Anything, SubjInterface, AbstractPersistentProxi, ProgramManager4Public {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentProgramManager getThis() throws PersistenceException ;
    
    

}

