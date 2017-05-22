package persistence;



import model.visitor.*;

public class UserManagerICProxi extends ServiceICProxi implements PersistentUserManager{
    
    public UserManagerICProxi(long objectId) {
        super(objectId);
    }
    public UserManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUserManagerFacade
            .getUserManager(this.getId());
    }
    
    public long getClassId() {
        return -116;
    }
    
    public PersistentUserManager getThis() throws PersistenceException {
        return ((PersistentUserManager)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManager(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManager(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManager(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManager(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManager(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManager(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManager(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).signalChanged(signal);
    }
    public String userManager_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentUserManager)this.getTheObject()).userManager_Menu_Filter(anything);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentUserManager)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void userManagerOP() 
				throws PersistenceException{
        ((PersistentUserManager)this.getTheObject()).userManagerOP();
    }

    
}
