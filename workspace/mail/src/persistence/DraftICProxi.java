package persistence;



import model.visitor.*;

public class DraftICProxi extends MailICProxi implements PersistentDraft{
    
    public DraftICProxi(long objectId) {
        super(objectId);
    }
    public DraftICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDraftFacade
            .getDraft(this.getId());
    }
    
    public long getClassId() {
        return 133;
    }
    
    public AccountWrapper4Public getSender() throws PersistenceException {
        return ((PersistentDraft)this.getTheObject()).getSender();
    }
    public void setSender(AccountWrapper4Public newValue) throws PersistenceException {
        ((PersistentDraft)this.getTheObject()).setSender(newValue);
    }
    public PersistentDraft getThis() throws PersistenceException {
        return ((PersistentDraft)this.getTheObject()).getThis();
    }
    
    public void accept(MailVisitor visitor) throws PersistenceException {
        visitor.handleDraft(this);
    }
    public <R> R accept(MailReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDraft(this);
    }
    public <E extends model.UserException>  void accept(MailExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDraft(this);
    }
    public <R, E extends model.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDraft(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDraft(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDraft(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDraft(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDraft(this);
    }
    
    
    public FolderSearchList getParentFolder() 
				throws PersistenceException{
        return ((PersistentDraft)this.getTheObject()).getParentFolder();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDraft)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addReceiver(final Account4Public account) 
				throws PersistenceException{
        ((PersistentDraft)this.getTheObject()).addReceiver(account);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDraft)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDraft)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDraft)this.getTheObject()).initializeOnInstantiation();
    }
    public MailEntry4Public send() 
				throws PersistenceException{
        return ((PersistentDraft)this.getTheObject()).send();
    }

    
}
