package persistence;



public abstract class GradeICProxi extends PersistentInCacheProxiOptimistic implements PersistentGrade{
    
    public GradeICProxi(long objectId) {
        super(objectId);
    }
    public GradeICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentGrade getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGrade)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentGrade)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentGrade)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentGrade)this.getTheObject()).initializeOnInstantiation();
    }
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
        return ((PersistentGrade)this.getTheObject()).toFraction();
    }

    
}
