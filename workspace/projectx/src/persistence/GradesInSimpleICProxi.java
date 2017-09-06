package persistence;



public abstract class GradesInSimpleICProxi extends GradesInSimpleOrThirdICProxi implements PersistentGradesInSimple{
    
    public GradesInSimpleICProxi(long objectId) {
        super(objectId);
    }
    public GradesInSimpleICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentGradesInSimple getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentGradesInSimple)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentGradesInSimple)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentGradesInSimple)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentGradesInSimple)this.getTheObject()).initializeOnInstantiation();
    }

    
}
