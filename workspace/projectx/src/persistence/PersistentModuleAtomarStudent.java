package persistence;


public interface PersistentModuleAtomarStudent extends PersistentModuleAbstractStudent, ModuleAtomarStudent4Public {
    
    public void setGrade(GradesInSimpleOrThird4Public newValue) throws PersistenceException ;
    public PersistentModuleAtomarStudent getThis() throws PersistenceException ;
    
    

}

