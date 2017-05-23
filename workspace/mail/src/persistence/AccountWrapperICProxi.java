package persistence;



import model.visitor.*;

public class AccountWrapperICProxi extends abstractAccICProxi implements PersistentAccountWrapper{
    
    public AccountWrapperICProxi(long objectId) {
        super(objectId);
    }
    public AccountWrapperICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountWrapperFacade
            .getAccountWrapper(this.getId());
    }
    
    public long getClassId() {
        return 139;
    }
    
    public Account4Public getWrapped() throws PersistenceException {
        return ((PersistentAccountWrapper)this.getTheObject()).getWrapped();
    }
    public void setWrapped(Account4Public newValue) throws PersistenceException {
        ((PersistentAccountWrapper)this.getTheObject()).setWrapped(newValue);
    }
    public PersistentAccountWrapper getThis() throws PersistenceException {
        return ((PersistentAccountWrapper)this.getTheObject()).getThis();
    }
    
    public void accept(abstractAccVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrapper(this);
    }
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrapper(this);
    }
    public <E extends model.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrapper(this);
    }
    public <R, E extends model.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrapper(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrapper(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrapper(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrapper(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountWrapper)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountWrapper)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createDraft(final String subject, final String text) 
				throws PersistenceException{
        ((PersistentAccountWrapper)this.getTheObject()).createDraft(subject, text);
    }
    public void createFolder(final String name) 
				throws PersistenceException{
        ((PersistentAccountWrapper)this.getTheObject()).createFolder(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountWrapper)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountWrapper)this.getTheObject()).initializeOnInstantiation();
    }
    public void receive(final MailEntry4Public mail) 
				throws PersistenceException{
        ((PersistentAccountWrapper)this.getTheObject()).receive(mail);
    }
    public void send(final Draft4Public draft) 
				throws PersistenceException{
        ((PersistentAccountWrapper)this.getTheObject()).send(draft);
    }
    public Account4Public wrappedAcc() 
				throws PersistenceException{
        return ((PersistentAccountWrapper)this.getTheObject()).wrappedAcc();
    }

    
}
