package persistence;



public abstract class GradesInSimpleOrThirdICProxi extends PersistentInCacheProxiOptimistic implements PersistentGradesInSimpleOrThird{
    
    public GradesInSimpleOrThirdICProxi(long objectId) {
        super(objectId);
    }
    public GradesInSimpleOrThirdICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentGradesInSimpleOrThird getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGradesInSimpleOrThird)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentGradesInSimpleOrThird)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentGradesInSimpleOrThird)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentGradesInSimpleOrThird)this.getTheObject()).initializeOnInstantiation();
    }

    
}
