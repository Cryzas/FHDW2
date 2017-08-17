package persistence;


public interface PersistentModuleAtomarStudent extends PersistentModuleAbstractStudent, ModuleAtomarStudent4Public {
    
    public PersistentModuleAtomarStudent getThis() throws PersistenceException ;
    
    
    public common.Fraction getOwnCreditPoints() 
				throws PersistenceException;

}

