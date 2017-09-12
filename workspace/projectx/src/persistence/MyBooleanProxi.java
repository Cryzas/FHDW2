package persistence;



public abstract class MyBooleanProxi extends PersistentProxi implements PersistentMyBoolean{
    
    public MyBooleanProxi(long objectId) {
        super(objectId);
    }
    public MyBooleanProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public abstract PersistentMyBoolean getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMyBoolean)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMyBoolean)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMyBoolean)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMyBoolean)this.getTheObject()).initializeOnInstantiation();
    }

    
}
