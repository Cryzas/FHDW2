package persistence;


public interface PersistentModuleAtomarStudent extends LectureWithGrade, PersistentModuleAbstractStudent, ModuleAtomarStudent4Public {
    
    public void setOwnGrade(GradesInSimpleOrThird4Public newValue) throws PersistenceException ;
    public PersistentModuleAtomarStudent getThis() throws PersistenceException ;
    
    

}

