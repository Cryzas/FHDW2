package persistence;



import model.visitor.*;

public class TransferICProxi extends PersistentInCacheProxiOptimistic implements PersistentTransfer{
    
    public TransferICProxi(long objectId) {
        super(objectId);
    }
    public TransferICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTransferFacade
            .getTransfer(this.getId());
    }
    
    public long getClassId() {
        return 134;
    }
    
    public String getDescription() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getDescription();
    }
    public void setDescription(String newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setDescription(newValue);
    }
    public common.Fraction getAmount() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setAmount(newValue);
    }
    public Account4Public getFromAcc() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getFromAcc();
    }
    public void setFromAcc(Account4Public newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setFromAcc(newValue);
    }
    public Account4Public getToAcc() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getToAcc();
    }
    public void setToAcc(Account4Public newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setToAcc(newValue);
    }
    public PersistentTransfer getThis() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getThis();
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
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initialize(This, final$$Fields);
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
