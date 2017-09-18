package persistence;



public abstract class GradesInSimpleOrThirdICProxi extends GradeICProxi implements PersistentGradesInSimpleOrThird{
    
    public GradesInSimpleOrThirdICProxi(long objectId) {
        super(objectId);
    }
    public GradesInSimpleOrThirdICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentGradesInSimpleOrThird getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentGradesInSimpleOrThird)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGradesInSimpleOrThird)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentGradesInSimpleOrThird)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentGradesInSimpleOrThird)this.getTheObject()).updateObservers(event);
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
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
        return ((PersistentGradesInSimpleOrThird)this.getTheObject()).toFraction();
    }

    
}
