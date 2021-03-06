package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UserManagerProxi extends ServiceProxi implements UserManagerView{
    
    public UserManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public UserManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        java.util.Vector<String> crrntServers_string = (java.util.Vector<String>)resultTable.get("crrntServers");
        java.util.Vector<ServerView> crrntServers = ViewProxi.getProxiVector(crrntServers_string, connectionKey);
        UserManagerView result$$ = new UserManager(errors,crrntServers, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCrrntServers().size()) return new CrrntServersUserManagerWrapper(this, originalIndex, (ViewRoot)this.getCrrntServers().get(index));
        index = index - this.getCrrntServers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCrrntServers().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getCrrntServers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCrrntServersIterator = this.getCrrntServers().iterator();
        while(getCrrntServersIterator.hasNext()){
            if(getCrrntServersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ServerView> getCrrntServers()throws ModelException{
        return ((UserManager)this.getTheObject()).getCrrntServers();
    }
    public void setCrrntServers(java.util.Vector<ServerView> newValue) throws ModelException {
        ((UserManager)this.getTheObject()).setCrrntServers(newValue);
    }
    
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUserManager(this);
    }
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUserManager(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUserManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUserManager(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUserManager(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUserManager(this);
    }
    
    
    public UserManagerConnection connectUserManager(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        UserManagerConnection result;
		try {
			result = (UserManagerConnection) new UserManagerConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
