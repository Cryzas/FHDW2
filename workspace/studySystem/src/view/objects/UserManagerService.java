
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class UserManagerService extends view.objects.subAdminService implements UserManagerServiceView{
    
    protected java.util.Vector<ServerView> users;
    
    public UserManagerService(AdminServiceView parentService,java.util.Vector<ErrorDisplayView> errors,java.util.Vector<ServerView> users,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AdminServiceView)parentService,errors,id, classId);
        this.users = users;        
    }
    
    static public long getTypeId() {
        return -290;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ServerView> getUsers()throws ModelException{
        return this.users;
    }
    public void setUsers(java.util.Vector<ServerView> newValue) throws ModelException {
        this.users = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AdminServiceView parentService = this.getParentService();
        if (parentService != null) {
            ((ViewProxi)parentService).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(parentService.getClassId(), parentService.getId())));
        }
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        java.util.Vector<?> users = this.getUsers();
        if (users != null) {
            ViewObject.resolveVectorProxies(users, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        this.users = this.usersUserSort(this.users);
        
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
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
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    protected java.util.Vector<ServerView> usersUserSort(java.util.Vector<ServerView> users) {
        	
    	class UsersUserSort implements Comparable<UsersUserSort> {
    		ServerView wrapped;
    		public UsersUserSort(ServerView wrapped) {
    			this.wrapped = wrapped;
    		}
    		public int compareTo(UsersUserSort o) {
    			//usersUserSortMethodBegin
    			try {
					return String.CASE_INSENSITIVE_ORDER.compare(wrapped.getUser(), o.wrapped.getUser());
				} catch (ModelException e) {
					return -1;
				} 
    			//usersUserSortMethodEnd
    		}
    	}
    	java.util.TreeSet <UsersUserSort> sorted = new java.util.TreeSet<UsersUserSort>();
    	java.util.Iterator<ServerView> entries = users.iterator();
    	while (entries.hasNext())sorted.add(new UsersUserSort((ServerView) entries.next()));
    	java.util.Vector<ServerView> result = new java.util.Vector<ServerView>();
    	java.util.Iterator<UsersUserSort> sortedEntries = sorted.iterator();
    	while (sortedEntries.hasNext())result.add(sortedEntries.next().wrapped);
    	return result;
    }
    
}
