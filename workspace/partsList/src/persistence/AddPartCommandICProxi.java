package persistence;



import model.visitor.*;

public class AddPartCommandICProxi extends PersistentInCacheProxi implements PersistentAddPartCommand{
    
    public AddPartCommandICProxi(long objectId) {
        super(objectId);
    }
    public AddPartCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddPartCommandFacade
            .getAddPartCommand(this.getId());
    }
    
    public long getClassId() {
        return 120;
    }
    
    public Component4Public getComponent() throws PersistenceException {
        return ((PersistentAddPartCommand)this.getTheObject()).getComponent();
    }
    public void setComponent(Component4Public newValue) throws PersistenceException {
        ((PersistentAddPartCommand)this.getTheObject()).setComponent(newValue);
    }
    public long getQuantity() throws PersistenceException {
        return ((PersistentAddPartCommand)this.getTheObject()).getQuantity();
    }
    public void setQuantity(long newValue) throws PersistenceException {
        ((PersistentAddPartCommand)this.getTheObject()).setQuantity(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddPartCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddPartCommand)this.getTheObject()).setInvoker(newValue);
    }
    public Product4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentAddPartCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(Product4Public newValue) throws PersistenceException {
        ((PersistentAddPartCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public CommonDate4Public getMyCommonDate() throws PersistenceException {
        return ((PersistentAddPartCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException {
        ((PersistentAddPartCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddPartCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddPartCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddPartCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddPartCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddPartCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPartCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPartCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPartCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddPartCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPartCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPartCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPartCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddPartCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPartCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPartCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPartCommand(this);
    }
    public void accept(ProductCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddPartCommand(this);
    }
    public <R> R accept(ProductCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddPartCommand(this);
    }
    public <E extends model.UserException>  void accept(ProductCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddPartCommand(this);
    }
    public <R, E extends model.UserException> R accept(ProductCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddPartCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentAddPartCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAddPartCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddPartCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddPartCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddPartCommand)this.getTheObject()).sendResult();
    }

    
}
