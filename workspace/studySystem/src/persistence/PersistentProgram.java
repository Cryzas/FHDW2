package persistence;


public interface PersistentProgram extends Anything, programHierarchyHIERARCHY, SubjInterface, AbstractPersistentProxi, Program4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentProgram getThis() throws PersistenceException ;
    
    

}

