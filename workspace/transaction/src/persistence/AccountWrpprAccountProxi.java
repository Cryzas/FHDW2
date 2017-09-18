package persistence;



import model.visitor.*;

public class AccountWrpprAccountProxi extends PersistentProxi implements PersistentAccountWrpprAccount{
    
    public AccountWrpprAccountProxi(long objectId) {
        super(objectId);
    }
    public AccountWrpprAccountProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 134;
    }
    
    public AccountWrppr4Public getObserver() throws PersistenceException {
        return ((PersistentAccountWrpprAccount)this.getTheObject()).getObserver();
    }
    public void setObserver(AccountWrppr4Public newValue) throws PersistenceException {
        ((PersistentAccountWrpprAccount)this.getTheObject()).setObserver(newValue);
    }
    public Account4Public getObservee() throws PersistenceException {
        return ((PersistentAccountWrpprAccount)this.getTheObject()).getObservee();
    }
    public void setObservee(Account4Public newValue) throws PersistenceException {
        ((PersistentAccountWrpprAccount)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountWrpprAccount getThis() throws PersistenceException {
        return ((PersistentAccountWrpprAccount)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrpprAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrpprAccount(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrpprAccount(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrpprAccount(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrpprAccount(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrpprAccount(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrpprAccount(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrpprAccount(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountWrpprAccount)this.getTheObject()).update(event);
    }

    
}
