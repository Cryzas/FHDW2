package persistence;



import model.visitor.*;

public class TransferProxi extends AbstractTransferProxi implements PersistentTransfer{
    
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
    
    public void accept(AbstractTransferVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AbstractTransferReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(AbstractTransferExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(AbstractTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).updateObservers(event);
    }
    public void book() 
				throws model.TransferException, PersistenceException{
        ((PersistentTransfer)this.getTheObject()).book();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void doBooking() 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).doBooking();
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
