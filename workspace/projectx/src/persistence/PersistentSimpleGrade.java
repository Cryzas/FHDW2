package persistence;


public interface PersistentSimpleGrade extends PersistentGradeSystem, SimpleGrade4Public {
    
    public PersistentSimpleGrade getThis() throws PersistenceException ;
    
    

}

