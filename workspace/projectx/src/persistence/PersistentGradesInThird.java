package persistence;


public interface PersistentGradesInThird extends PersistentGradesInSimpleOrThird, GradesInThird4Public {
    
    public abstract PersistentGradesInThird getThis() throws PersistenceException ;
    
    

}

