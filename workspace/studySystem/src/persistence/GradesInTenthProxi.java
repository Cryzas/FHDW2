package persistence;



public abstract class GradesInTenthProxi extends GradeProxi implements PersistentGradesInTenth{
    
    public GradesInTenthProxi(long objectId) {
        super(objectId);
    }
    public GradesInTenthProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public abstract PersistentGradesInTenth getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGradesInTenth)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentGradesInTenth)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentGradesInTenth)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentGradesInTenth)this.getTheObject()).initializeOnInstantiation();
    }
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
        return ((PersistentGradesInTenth)this.getTheObject()).toFraction();
    }

    
}
