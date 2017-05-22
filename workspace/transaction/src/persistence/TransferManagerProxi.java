package persistence;



import model.visitor.*;

public class TransferManagerProxi extends PersistentProxi implements PersistentTransferManager{
    
    public TransferManagerProxi(long objectId) {
        super(objectId);
    }
    public TransferManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 114;
    }
    
    public TransferManager_TransfersProxi getTransfers() throws PersistenceException {
        return ((PersistentTransferManager)this.getTheObject()).getTransfers();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTransferManager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTransferManager)this.getTheObject()).setSubService(newValue);
    }
    public PersistentTransferManager getThis() throws PersistenceException {
        return ((PersistentTransferManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransferManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransferManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransferManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransferManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransferManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransferManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransferManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransferManager(this);
    }
    
    
    public void addTransfer(final Transaction4Public transaction, final Transfer4Public transfer, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).addTransfer(transaction, transfer, invoker);
    }
    public void book(final Bookable4Public bookable, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).book(bookable, invoker);
    }
    public void createTransaction(final String subject, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).createTransaction(subject, invoker);
    }
    public void createTransfer(final AccountHandle4Public fromAccount, final AccountHandle4Public toAccount, final common.Fraction amount, final String subject, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).createTransfer(fromAccount, toAccount, amount, subject, invoker);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).register(observee);
    }
    public void removeTransfer(final Transaction4Public transaction, final Transfer4Public transfer, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).removeTransfer(transaction, transfer, invoker);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).updateObservers(event);
    }
    public void addTransfer(final Transaction4Public transaction, final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).addTransfer(transaction, transfer);
    }
    public void book(final Bookable4Public bookable) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).book(bookable);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createTransaction(final String subject) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).createTransaction(subject);
    }
    public void createTransfer(final AccountHandle4Public fromAccount, final AccountHandle4Public toAccount, final common.Fraction amount, final String subject) 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).createTransfer(fromAccount, toAccount, amount, subject);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeTransfer(final Transaction4Public transaction, final Transfer4Public transfer) 
				throws model.NotPartException, PersistenceException{
        ((PersistentTransferManager)this.getTheObject()).removeTransfer(transaction, transfer);
    }

    
}
