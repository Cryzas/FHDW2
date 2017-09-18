package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UserManagerServiceProxi extends subAdminServiceProxi implements UserManagerServiceView{
    
    public UserManagerServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public UserManagerServiceView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi parentService = null;
        String parentService$String = (String)resultTable.get("parentService");
        if (parentService$String != null) {
            common.ProxiInformation parentService$Info = common.RPCConstantsAndServices.createProxiInformation(parentService$String);
            parentService = view.objects.ViewProxi.createProxi(parentService$Info,connectionKey);
            parentService.setToString(parentService$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        java.util.Vector<String> users_string = (java.util.Vector<String>)resultTable.get("users");
        java.util.Vector<ServerView> users = ViewProxi.getProxiVector(users_string, connectionKey);
        UserManagerServiceView result$$ = new UserManagerService((AdminServiceView)parentService,errors,users, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getUsers().size()) return new UsersUserManagerServiceWrapper(this, originalIndex, (ViewRoot)this.getUsers().get(index));
        index = index - this.getUsers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUsers().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getUsers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getUsersIterator = this.getUsers().iterator();
        while(getUsersIterator.hasNext()){
            if(getUsersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ServerView> getUsers()throws ModelException{
        return ((UserManagerService)this.getTheObject()).getUsers();
    }
    public void setUsers(java.util.Vector<ServerView> newValue) throws ModelException {
        ((UserManagerService)this.getTheObject()).setUsers(newValue);
    }
    
    public void accept(subAdminServiceVisitor visitor) throws ModelException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends view.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends view.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUserManagerService(this);
    }
    
    
    public UserManagerServiceConnection connectUserManagerService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        UserManagerServiceConnection result;
		try {
			result = (UserManagerServiceConnection) new UserManagerServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
