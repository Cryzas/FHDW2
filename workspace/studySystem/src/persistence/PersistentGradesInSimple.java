package persistence;


public interface PersistentGradesInSimple extends PersistentGradesInSimpleOrThird, GradesInSimple4Public {
    
    public abstract PersistentGradesInSimple getThis() throws PersistenceException ;
    
    

}

