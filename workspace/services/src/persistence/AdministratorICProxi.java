package persistence;



import model.visitor.*;

public class AdministratorICProxi extends ServiceICProxi implements PersistentAdministrator{
    
    public AdministratorICProxi(long objectId) {
        super(objectId);
    }
    public AdministratorICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
            .getAdministrator(this.getId());
    }
    
    public long getClassId() {
        return -114;
    }
    
    public PersistentAdministrator getThis() throws PersistenceException {
        return ((PersistentAdministrator)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    
    
    public String administrator_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentAdministrator)this.getTheObject()).administrator_Menu_Filter(anything);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).signalChanged(signal);
    }
    public void administratorOp() 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).administratorOp();
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentAdministrator)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAdministrator)this.getTheObject()).initializeOnInstantiation();
    }

    
}
