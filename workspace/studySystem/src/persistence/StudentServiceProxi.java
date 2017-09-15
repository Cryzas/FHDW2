package persistence;



import model.visitor.*;

public class StudentServiceProxi extends ServiceProxi implements PersistentStudentService{
    
    public StudentServiceProxi(long objectId) {
        super(objectId);
    }
    public StudentServiceProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -286;
    }
    
    public PersistentStudentService getThis() throws PersistenceException {
        return ((PersistentStudentService)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentService(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentService(this);
    }
    
    
    public ServerSearchList getParentServer() 
				throws PersistenceException{
        return ((PersistentStudentService)this.getTheObject()).getParentServer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).signalChanged(signal);
    }
    public String studentService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentStudentService)this.getTheObject()).studentService_Menu_Filter(anything);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).disconnected();
    }
    public Student4Public getStudent() 
				throws PersistenceException{
        return ((PersistentStudentService)this.getTheObject()).getStudent();
    }
    public String getUsername() 
				throws PersistenceException{
        return ((PersistentStudentService)this.getTheObject()).getUsername();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentStudentService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudentService)this.getTheObject()).initializeOnInstantiation();
    }

    
}
