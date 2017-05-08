package persistence;



public abstract class EntryProxi extends PersistentProxi implements PersistentEntry{
    
    public EntryProxi(long objectId) {
        super(objectId);
    }
    public EntryProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public String getDescription() throws PersistenceException {
        return ((PersistentEntry)this.getTheObject()).getDescription();
    }
    public void setDescription(String newValue) throws PersistenceException {
        ((PersistentEntry)this.getTheObject()).setDescription(newValue);
    }
    public common.Fraction getAmount() throws PersistenceException {
        return ((PersistentEntry)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        ((PersistentEntry)this.getTheObject()).setAmount(newValue);
    }
    public Account4Public getOtherAcc() throws PersistenceException {
        return ((PersistentEntry)this.getTheObject()).getOtherAcc();
    }
    public void setOtherAcc(Account4Public newValue) throws PersistenceException {
        ((PersistentEntry)this.getTheObject()).setOtherAcc(newValue);
    }
    public abstract PersistentEntry getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).initializeOnInstantiation();
    }

    
}
