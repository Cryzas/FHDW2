package persistence;



import model.visitor.*;

public class ServerICProxi extends PersistentInCacheProxiOptimistic implements PersistentServer{
    
    public ServerICProxi(long objectId) {
        super(objectId);
    }
    public ServerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theServerFacade
            .getServer(this.getId());
    }
    
    public long getClassId() {
        return -102;
    }
    
    public AccountManager4Public getAccounts() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getAccounts();
    }
    public void setAccounts(AccountManager4Public newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setAccounts(newValue);
    }
    public TransferManager4Public getTransfers() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getTransfers();
    }
    public void setTransfers(TransferManager4Public newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setTransfers(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setSubService(newValue);
    }
    public Server_ErrorsProxi getErrors() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getErrors();
    }
    public String getPassword() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getPassword();
    }
    public void setPassword(String newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setPassword(newValue);
    }
    public String getUser() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getUser();
    }
    public void setUser(String newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setUser(newValue);
    }
    public long getHackCount() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getHackCount();
    }
    public void setHackCount(long newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setHackCount(newValue);
    }
    public java.sql.Timestamp getHackDelay() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getHackDelay();
    }
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setHackDelay(newValue);
    }
    public PersistentServer getThis() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getThis();
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).register(observee);
    }
    public String server_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).server_Menu_Filter(anything);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).updateObservers(event);
    }
    public void addTransfer(final Transaction4Public transaction, final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addTransfer(transaction, transfer);
    }
    public void book(final Bookable4Public bookable) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).book(bookable);
    }
    public void clearAccounts() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).clearAccounts();
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAccount(final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createAccount(name);
    }
    public void createCredit(final Account4Public myAccount, final AccountHandle4Public otherAccount, final common.Fraction amount, final String subject) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createCredit(myAccount, otherAccount, amount, subject);
    }
    public void createDebit(final Account4Public myAccount, final AccountHandle4Public otherAccount, final common.Fraction amount, final String subject) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createDebit(myAccount, otherAccount, amount, subject);
    }
    public void createTransaction(final String subject) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createTransaction(subject);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).disconnected();
    }
    public void findAccounts(final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).findAccounts(name);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeTransfer(final Transaction4Public transaction, final Transfer4Public transfer) 
				throws model.NotPartException, PersistenceException{
        ((PersistentServer)this.getTheObject()).removeTransfer(transaction, transfer);
    }

    
}
