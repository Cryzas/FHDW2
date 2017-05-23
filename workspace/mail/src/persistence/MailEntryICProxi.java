package persistence;



import model.visitor.*;

public class MailEntryICProxi extends MailICProxi implements PersistentMailEntry{
    
    public MailEntryICProxi(long objectId) {
        super(objectId);
    }
    public MailEntryICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMailEntryFacade
            .getMailEntry(this.getId());
    }
    
    public long getClassId() {
        return 134;
    }
    
    public AccountWrapper4Public getSender() throws PersistenceException {
        return ((PersistentMailEntry)this.getTheObject()).getSender();
    }
    public void setSender(AccountWrapper4Public newValue) throws PersistenceException {
        ((PersistentMailEntry)this.getTheObject()).setSender(newValue);
    }
    public PersistentMailEntry getThis() throws PersistenceException {
        return ((PersistentMailEntry)this.getTheObject()).getThis();
    }
    
    public void accept(MailVisitor visitor) throws PersistenceException {
        visitor.handleMailEntry(this);
    }
    public <R> R accept(MailReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMailEntry(this);
    }
    public <E extends model.UserException>  void accept(MailExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMailEntry(this);
    }
    public <R, E extends model.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMailEntry(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMailEntry(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMailEntry(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMailEntry(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMailEntry(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMailEntry)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void answer() 
				throws PersistenceException{
        ((PersistentMailEntry)this.getTheObject()).answer();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMailEntry)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMailEntry)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMailEntry)this.getTheObject()).initializeOnInstantiation();
    }

    
}
