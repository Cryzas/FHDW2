package persistence;



import model.visitor.*;

public class MailEntryProxi extends MailProxi implements PersistentMailEntry{
    
    public MailEntryProxi(long objectId) {
        super(objectId);
    }
    public MailEntryProxi(PersistentInCacheProxi object) {
        super(object);
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
    
    
    public FolderSearchList getParentFolder() 
				throws PersistenceException{
        return ((PersistentMailEntry)this.getTheObject()).getParentFolder();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMailEntry)this.getTheObject()).initialize(This, final$$Fields);
    }
    public Draft4Public answerAll(final String subject, final String text, final AccountWrapper4Public sender) 
				throws PersistenceException{
        return ((PersistentMailEntry)this.getTheObject()).answerAll(subject, text, sender);
    }
    public Draft4Public answer(final String subject, final String text, final AccountWrapper4Public sender) 
				throws PersistenceException{
        return ((PersistentMailEntry)this.getTheObject()).answer(subject, text, sender);
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
