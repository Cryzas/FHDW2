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
        ViewProxi systemRoot = null;
        String systemRoot$String = (String)resultTable.get("systemRoot");
        if (systemRoot$String != null) {
            common.ProxiInformation systemRoot$Info = common.RPCConstantsAndServices.createProxiInformation(systemRoot$String);
            systemRoot = view.objects.ViewProxi.createProxi(systemRoot$Info,connectionKey);
            systemRoot.setToString(systemRoot$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String user = (String)resultTable.get("user");
        ServerView result$$ = new Server((FileSystemView)systemRoot,errors,(String)user, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getSystemRoot() != null && index < this.getSystemRoot().getTheObject().getChildCount())
            return this.getSystemRoot().getTheObject().getChild(index);
        if(this.getSystemRoot() != null) index = index - this.getSystemRoot().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSystemRoot() == null ? 0 : this.getSystemRoot().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSystemRoot() == null ? true : this.getSystemRoot().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSystemRoot() != null && this.getSystemRoot().equals(child)) return result;
        if(this.getSystemRoot() != null) result = result + 1;
        return -1;
    }
    
    public FileSystemView getSystemRoot()throws ModelException{
        return ((Server)this.getTheObject()).getSystemRoot();
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
        return true;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
