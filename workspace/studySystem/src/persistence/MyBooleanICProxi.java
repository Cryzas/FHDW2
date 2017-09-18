package persistence;



public abstract class MyBooleanICProxi extends PersistentInCacheProxiOptimistic implements PersistentMyBoolean{
    
    public MyBooleanICProxi(long objectId) {
        super(objectId);
    }
    public MyBooleanICProxi(PersistentObject object) {
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
    public boolean toBoolean() 
				throws PersistenceException{
        return ((PersistentMyBoolean)this.getTheObject()).toBoolean();
    }

    
}
