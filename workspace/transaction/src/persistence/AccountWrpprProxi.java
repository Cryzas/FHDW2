package persistence;



import model.visitor.*;

public class AccountWrpprProxi extends AccountHandleProxi implements PersistentAccountWrppr{
    
    public AccountWrpprProxi(long objectId) {
        super(objectId);
    }
    public AccountWrpprProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 118;
    }
    
    public Account4Public getAccount() throws PersistenceException {
        return ((PersistentAccountWrppr)this.getTheObject()).getAccount();
    }
    public void setAccount(Account4Public newValue) throws PersistenceException {
        ((PersistentAccountWrppr)this.getTheObject()).setAccount(newValue);
    }
    public PersistentAccountWrppr getThis() throws PersistenceException {
        return ((PersistentAccountWrppr)this.getTheObject()).getThis();
    }
    
    public void accept(AccountHandleVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Account4Public fetchAccount() 
				throws PersistenceException{
        return ((PersistentAccountWrppr)this.getTheObject()).fetchAccount();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).initializeOnInstantiation();
    }

    
}
