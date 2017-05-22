package persistence;



import model.visitor.*;

public class TransactionProxi extends BookableProxi implements PersistentTransaction{
    
    public TransactionProxi(long objectId) {
        super(objectId);
    }
    public TransactionProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 135;
    }
    
    public Transaction_TransfersProxi getTransfers() throws PersistenceException {
        return ((PersistentTransaction)this.getTheObject()).getTransfers();
    }
    public PersistentTransaction getThis() throws PersistenceException {
        return ((PersistentTransaction)this.getTheObject()).getThis();
    }
    
    public void accept(BookableVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends model.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends model.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(bookableHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(bookableHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends model.UserException>  void accept(bookableHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends model.UserException> R accept(bookableHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    
    
    public boolean containsbookableHierarchy(final bookableHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentTransaction)this.getTheObject()).containsbookableHierarchy(part);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).register(observee);
    }
    public <T> T strategybookableHierarchy(final bookableHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentTransaction)this.getTheObject()).strategybookableHierarchy(strategy);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).updateObservers(event);
    }
    public void addTransfer(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).addTransfer(transfer);
    }
    public void book() 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).book();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeTransfer(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).removeTransfer(transfer);
    }

    
}
