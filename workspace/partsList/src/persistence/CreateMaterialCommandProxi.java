package persistence;



import model.visitor.*;

public class CreateMaterialCommandProxi extends PersistentProxi implements PersistentCreateMaterialCommand{
    
    public CreateMaterialCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateMaterialCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 122;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateMaterialCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateMaterialCommand)this.getTheObject()).setName(newValue);
    }
    public common.Fraction getPrice() throws PersistenceException {
        return ((PersistentCreateMaterialCommand)this.getTheObject()).getPrice();
    }
    public void setPrice(common.Fraction newValue) throws PersistenceException {
        ((PersistentCreateMaterialCommand)this.getTheObject()).setPrice(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateMaterialCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateMaterialCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PartsListManager4Public getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateMaterialCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PartsListManager4Public newValue) throws PersistenceException {
        ((PersistentCreateMaterialCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public CommonDate4Public getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateMaterialCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(CommonDate4Public newValue) throws PersistenceException {
        ((PersistentCreateMaterialCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateMaterialCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateMaterialCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateMaterialCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateMaterialCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateMaterialCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMaterialCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMaterialCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMaterialCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateMaterialCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMaterialCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMaterialCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMaterialCommand(this);
    }
    public void accept(PartsListManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMaterialCommand(this);
    }
    public <R> R accept(PartsListManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMaterialCommand(this);
    }
    public <E extends model.UserException>  void accept(PartsListManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMaterialCommand(this);
    }
    public <R, E extends model.UserException> R accept(PartsListManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMaterialCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateMaterialCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateMaterialCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateMaterialCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateMaterialCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentCreateMaterialCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateMaterialCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateMaterialCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateMaterialCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateMaterialCommand)this.getTheObject()).sendResult();
    }

    
}
