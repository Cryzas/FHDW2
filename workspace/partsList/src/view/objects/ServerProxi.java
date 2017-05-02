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
        ViewProxi manager = null;
        String manager$String = (String)resultTable.get("manager");
        if (manager$String != null) {
            common.ProxiInformation manager$Info = common.RPCConstantsAndServices.createProxiInformation(manager$String);
            manager = view.objects.ViewProxi.createProxi(manager$Info,connectionKey);
            manager.setToString(manager$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String user = (String)resultTable.get("user");
        ServerView result$$ = new Server((PartsListManagerView)manager,errors,(String)user, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getManager() != null) return new ManagerServerWrapper(this, originalIndex, (ViewRoot)this.getManager());
        if(this.getManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getManager() != null && this.getManager().equals(child)) return result;
        if(this.getManager() != null) result = result + 1;
        return -1;
    }
    
    public PartsListManagerView getManager()throws ModelException{
        return ((Server)this.getTheObject()).getManager();
    }
    public void setManager(PartsListManagerView newValue) throws ModelException {
        ((Server)this.getTheObject()).setManager(newValue);
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
