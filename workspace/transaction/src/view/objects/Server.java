
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Server extends ViewObject implements ServerView{
    
    protected AccountManagerView accounts;
    protected TransferManagerView transfers;
    protected java.util.Vector<ErrorDisplayView> errors;
    protected String user;
    
    public Server(AccountManagerView accounts,TransferManagerView transfers,java.util.Vector<ErrorDisplayView> errors,String user,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.accounts = accounts;
        this.transfers = transfers;
        this.errors = errors;
        this.user = user;        
    }
    
    static public long getTypeId() {
        return -102;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public AccountManagerView getAccounts()throws ModelException{
        return this.accounts;
    }
    public void setAccounts(AccountManagerView newValue) throws ModelException {
        this.accounts = newValue;
    }
    public TransferManagerView getTransfers()throws ModelException{
        return this.transfers;
    }
    public void setTransfers(TransferManagerView newValue) throws ModelException {
        this.transfers = newValue;
    }
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException{
        return this.errors;
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        this.errors = newValue;
    }
    public String getUser()throws ModelException{
        return this.user;
    }
    public void setUser(String newValue) throws ModelException {
        this.user = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AccountManagerView accounts = this.getAccounts();
        if (accounts != null) {
            ((ViewProxi)accounts).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(accounts.getClassId(), accounts.getId())));
        }
        TransferManagerView transfers = this.getTransfers();
        if (transfers != null) {
            ((ViewProxi)transfers).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(transfers.getClassId(), transfers.getId())));
        }
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getUserIndex() throws ModelException {
        return 0 + (this.getAccounts() == null ? 0 : 1) + (this.getTransfers() == null ? 0 : 1);
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "user";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getUser();
                rowIndex = rowIndex - 1;
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setUser(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
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
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
