package persistence;



public abstract class MailProxi extends PersistentProxi implements PersistentMail{
    
    public MailProxi(long objectId) {
        super(objectId);
    }
    public MailProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public Mail_ReceiversProxi getReceivers() throws PersistenceException {
        return ((PersistentMail)this.getTheObject()).getReceivers();
    }
    public String getSubject() throws PersistenceException {
        return ((PersistentMail)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentMail)this.getTheObject()).setSubject(newValue);
    }
    public String getText() throws PersistenceException {
        return ((PersistentMail)this.getTheObject()).getText();
    }
    public void setText(String newValue) throws PersistenceException {
        ((PersistentMail)this.getTheObject()).setText(newValue);
    }
    public abstract PersistentMail getThis() throws PersistenceException ;
    
    
    
    public FolderSearchList getParentFolder() 
				throws PersistenceException{
        return ((PersistentMail)this.getTheObject()).getParentFolder();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMail)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMail)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMail)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMail)this.getTheObject()).initializeOnInstantiation();
    }

    
}
