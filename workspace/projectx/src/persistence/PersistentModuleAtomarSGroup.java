package persistence;


public interface PersistentModuleAtomarSGroup extends PersistentModuleAbstractSGroup, ModuleAtomarSGroup4Public {
    
    public common.Fraction getOwnCreditPoints() throws PersistenceException ;
    public void setOwnCreditPoints(common.Fraction newValue) throws PersistenceException ;
    public void setGradeSystem(GradeSystem4Public newValue) throws PersistenceException ;
    public PersistentModuleAtomarSGroup getThis() throws PersistenceException ;
    
    

}

