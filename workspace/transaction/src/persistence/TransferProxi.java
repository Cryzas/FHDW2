package persistence;



import model.visitor.*;

public class TransferProxi extends BookableProxi implements PersistentTransfer{
    
    public TransferProxi(long objectId) {
        super(objectId);
    }
    public TransferProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 121;
    }
    
    public Account4Public getFromAccount() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getFromAccount();
    }
    public void setFromAccount(Account4Public newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setFromAccount(newValue);
    }
    public Account4Public getToAccount() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getToAccount();
    }
    public void setToAccount(Account4Public newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setToAccount(newValue);
    }
    public common.Fraction getAmount() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setAmount(newValue);
    }
    public PersistentTransfer getThis() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getThis();
    }
    
    public void accept(BookableVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(bookableHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(bookableHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(bookableHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(bookableHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    
    
    public boolean containsbookableHierarchy(final bookableHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).containsbookableHierarchy(part);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).register(observee);
    }
    public <T> T strategybookableHierarchy(final bookableHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).strategybookableHierarchy(strategy);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).updateObservers(event);
    }
    public void book() 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).book();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initializeOnInstantiation();
    }

    
}
