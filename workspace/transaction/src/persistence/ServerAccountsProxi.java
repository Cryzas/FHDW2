package persistence;



import model.visitor.*;

public class ServerAccountsProxi extends PersistentProxi implements PersistentServerAccounts{
    
    public ServerAccountsProxi(long objectId) {
        super(objectId);
    }
    public ServerAccountsProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 136;
    }
    
    public Server4Public getObserver() throws PersistenceException {
        return ((PersistentServerAccounts)this.getTheObject()).getObserver();
    }
    public void setObserver(Server4Public newValue) throws PersistenceException {
        ((PersistentServerAccounts)this.getTheObject()).setObserver(newValue);
    }
    public AccountManager4Public getObservee() throws PersistenceException {
        return ((PersistentServerAccounts)this.getTheObject()).getObservee();
    }
    public void setObservee(AccountManager4Public newValue) throws PersistenceException {
        ((PersistentServerAccounts)this.getTheObject()).setObservee(newValue);
    }
    public PersistentServerAccounts getThis() throws PersistenceException {
        return ((PersistentServerAccounts)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServerAccounts(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServerAccounts(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServerAccounts(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServerAccounts(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleServerAccounts(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServerAccounts(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServerAccounts(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServerAccounts(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentServerAccounts)this.getTheObject()).update(event);
    }

    
}
