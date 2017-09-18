package persistence;



import model.visitor.*;

public class AccountManagerCurrentAccountsICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountManagerCurrentAccounts{
    
    public AccountManagerCurrentAccountsICProxi(long objectId) {
        super(objectId);
    }
    public AccountManagerCurrentAccountsICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade
            .getAccountManagerCurrentAccounts(this.getId());
    }
    
    public long getClassId() {
        return 135;
    }
    
    public AccountManager4Public getObserver() throws PersistenceException {
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).getObserver();
    }
    public void setObserver(AccountManager4Public newValue) throws PersistenceException {
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).setObserver(newValue);
    }
    public AccountManagerCurrentAccounts_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).getObservee();
    }
    public PersistentAccountManagerCurrentAccounts getThis() throws PersistenceException {
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManagerCurrentAccounts(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManagerCurrentAccounts(this);
    }
    
    
    public void add(final AccountHandle4Public observee) 
				throws PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).add(observee);
    }
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<AccountHandle4Public,R,E> aggregtion) 
				throws E, PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<AccountHandle4Public,R> aggregtion) 
				throws PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).aggregate(aggregtion);
    }
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<AccountHandle4Public,E> procdure) 
				throws E, PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<AccountHandle4Public> procdure) 
				throws PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).applyToAll(procdure);
    }
    public <E extends model.UserException> void filterException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).filterException(predcate);
    }
    public void filter(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).filter(predcate);
    }
    public <E extends model.UserException> SearchListRoot<AccountHandle4Public> findAllException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).findAllException(predcate);
    }
    public SearchListRoot<AccountHandle4Public> findAll(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).findAll(predcate);
    }
    public <E extends model.UserException> AccountHandle4Public findFirstException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).findFirstException(predcate);
    }
    public AccountHandle4Public findFirst(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).findFirst(predcate);
    }
    public long getLength() 
				throws PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).getLength();
    }
    public AccountHandleSearchList getList() 
				throws PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).getList();
    }
    public java.util.Iterator<AccountHandle4Public> iterator() 
				throws PersistenceException{
        return ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).iterator();
    }
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).removeFirstFailure(predcate);
    }
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountManagerCurrentAccounts)this.getTheObject()).update(event);
    }

    
}
