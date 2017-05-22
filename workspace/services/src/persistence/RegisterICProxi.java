package persistence;



import model.visitor.*;

public class RegisterICProxi extends ServiceICProxi implements PersistentRegister{
    
    public RegisterICProxi(long objectId) {
        super(objectId);
    }
    public RegisterICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theRegisterFacade
            .getRegister(this.getId());
    }
    
    public long getClassId() {
        return -118;
    }
    
    public PersistentRegister getThis() throws PersistenceException {
        return ((PersistentRegister)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleRegister(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRegister(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRegister(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRegister(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleRegister(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRegister(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRegister(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRegister(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRegister(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRegister(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRegister(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRegister(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleRegister(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRegister(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRegister(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRegister(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).initialize(This, final$$Fields);
    }
    public String register_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentRegister)this.getTheObject()).register_Menu_Filter(anything);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).signalChanged(signal);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentRegister)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).initializeOnInstantiation();
    }
    public void register(final String accountName, final String password) 
				throws PersistenceException{
        ((PersistentRegister)this.getTheObject()).register(accountName, password);
    }

    
}
