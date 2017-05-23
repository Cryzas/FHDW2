package persistence;



public abstract class abstractAccICProxi extends PersistentInCacheProxiOptimistic implements PersistentabstractAcc{
    
    public abstractAccICProxi(long objectId) {
        super(objectId);
    }
    public abstractAccICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentabstractAcc)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentabstractAcc)this.getTheObject()).setName(newValue);
    }
    public abstract PersistentabstractAcc getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentabstractAcc)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentabstractAcc)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createDraft(final String subject, final String text) 
				throws PersistenceException{
        ((PersistentabstractAcc)this.getTheObject()).createDraft(subject, text);
    }
    public void createFolder(final String name) 
				throws PersistenceException{
        ((PersistentabstractAcc)this.getTheObject()).createFolder(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentabstractAcc)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentabstractAcc)this.getTheObject()).initializeOnInstantiation();
    }
    public void receive(final MailEntry4Public mail) 
				throws PersistenceException{
        ((PersistentabstractAcc)this.getTheObject()).receive(mail);
    }
    public void send(final Draft4Public draft) 
				throws PersistenceException{
        ((PersistentabstractAcc)this.getTheObject()).send(draft);
    }

    
}
