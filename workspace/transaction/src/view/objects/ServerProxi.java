package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ServerProxi extends ViewProxi implements ServerView{
    
    public ServerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ServerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi accounts = null;
        String accounts$String = (String)resultTable.get("accounts");
        if (accounts$String != null) {
            common.ProxiInformation accounts$Info = common.RPCConstantsAndServices.createProxiInformation(accounts$String);
            accounts = view.objects.ViewProxi.createProxi(accounts$Info,connectionKey);
            accounts.setToString(accounts$Info.getToString());
        }
        ViewProxi transfers = null;
        String transfers$String = (String)resultTable.get("transfers");
        if (transfers$String != null) {
            common.ProxiInformation transfers$Info = common.RPCConstantsAndServices.createProxiInformation(transfers$String);
            transfers = view.objects.ViewProxi.createProxi(transfers$Info,connectionKey);
            transfers.setToString(transfers$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String user = (String)resultTable.get("user");
        ServerView result$$ = new Server((AccountManagerView)accounts,(TransferManagerView)transfers,errors,(String)user, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getAccounts() != null) return new AccountsServerWrapper(this, originalIndex, (ViewRoot)this.getAccounts());
        if(this.getAccounts() != null) index = index - 1;
        if(index == 0 && this.getTransfers() != null) return new TransfersServerWrapper(this, originalIndex, (ViewRoot)this.getTransfers());
        if(this.getTransfers() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAccounts() == null ? 0 : 1)
            + (this.getTransfers() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAccounts() == null ? true : false)
            && (this.getTransfers() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAccounts() != null && this.getAccounts().equals(child)) return result;
        if(this.getAccounts() != null) result = result + 1;
        if(this.getTransfers() != null && this.getTransfers().equals(child)) return result;
        if(this.getTransfers() != null) result = result + 1;
        return -1;
    }
    
    public AccountManagerView getAccounts()throws ModelException{
        return ((Server)this.getTheObject()).getAccounts();
    }
    public void setAccounts(AccountManagerView newValue) throws ModelException {
        ((Server)this.getTheObject()).setAccounts(newValue);
    }
    public TransferManagerView getTransfers()throws ModelException{
        return ((Server)this.getTheObject()).getTransfers();
    }
    public void setTransfers(TransferManagerView newValue) throws ModelException {
        ((Server)this.getTheObject()).setTransfers(newValue);
    }
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException{
        return ((Server)this.getTheObject()).getErrors();
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        ((Server)this.getTheObject()).setErrors(newValue);
    }
    public String getUser()throws ModelException{
        return ((Server)this.getTheObject()).getUser();
    }
    public void setUser(String newValue) throws ModelException {
        ((Server)this.getTheObject()).setUser(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleServer(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleServer(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleServer(this);
    }
    
    
    public ServerConnection connectServer(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        ServerConnection result;
		try {
			result = (ServerConnection) new ServerConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
