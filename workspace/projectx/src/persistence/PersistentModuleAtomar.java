package persistence;


public interface PersistentModuleAtomar extends PersistentModuleAbstract, ModuleAtomar4Public {
    
    public void setOwnCreditPoints(common.Fraction newValue) throws PersistenceException ;
    public PersistentModuleAtomar getThis() throws PersistenceException ;
    
    

}

