package persistence;



import model.visitor.*;

public class UserManagerServiceProxi extends subAdminServiceProxi implements PersistentUserManagerService{
    
    public UserManagerServiceProxi(long objectId) {
        super(objectId);
    }
    public UserManagerServiceProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -290;
    }
    
    public UserManagerService_UsersProxi getUsers() throws PersistenceException {
        return ((PersistentUserManagerService)this.getTheObject()).getUsers();
    }
    public PersistentUserManagerService getThis() throws PersistenceException {
        return ((PersistentUserManagerService)this.getTheObject()).getThis();
    }
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).register(observee);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).updateObservers(event);
    }
    public void updatePLZ() 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).updatePLZ();
    }
    public String userManagerService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentUserManagerService)this.getTheObject()).userManagerService_Menu_Filter(anything);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAdminUser(final String name, final String pw) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).createAdminUser(name, pw);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentUserManagerService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).removeError(error);
    }
    public void updateMe() 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).updateMe();
    }
    public void updatePLZImplementation() 
				throws PersistenceException{
        ((PersistentUserManagerService)this.getTheObject()).updatePLZImplementation();
    }

    
}
