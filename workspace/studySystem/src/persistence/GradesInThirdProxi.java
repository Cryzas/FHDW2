package persistence;



public abstract class GradesInThirdProxi extends GradesInSimpleOrThirdProxi implements PersistentGradesInThird{
    
    public GradesInThirdProxi(long objectId) {
        super(objectId);
    }
    public GradesInThirdProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public abstract PersistentGradesInThird getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGradesInThird)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentGradesInThird)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentGradesInThird)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentGradesInThird)this.getTheObject()).initializeOnInstantiation();
    }
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
        return ((PersistentGradesInThird)this.getTheObject()).toFraction();
    }

    
}
