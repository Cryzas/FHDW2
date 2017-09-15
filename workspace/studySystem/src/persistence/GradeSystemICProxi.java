package persistence;



public abstract class GradeSystemICProxi extends PersistentInCacheProxiOptimistic implements PersistentGradeSystem{
    
    public GradeSystemICProxi(long objectId) {
        super(objectId);
    }
    public GradeSystemICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentGradeSystem getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGradeSystem)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentGradeSystem)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentGradeSystem)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentGradeSystem)this.getTheObject()).initializeOnInstantiation();
    }

    
}
