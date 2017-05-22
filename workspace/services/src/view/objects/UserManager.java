
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class UserManager extends view.objects.Service implements UserManagerView{
    
    protected java.util.Vector<ServerView> crrntServers;
    
    public UserManager(java.util.Vector<ErrorDisplayView> errors,java.util.Vector<ServerView> crrntServers,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(errors,id, classId);
        this.crrntServers = crrntServers;        
    }
    
    static public long getTypeId() {
        return -116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ServerView> getCrrntServers()throws ModelException{
        return this.crrntServers;
    }
    public void setCrrntServers(java.util.Vector<ServerView> newValue) throws ModelException {
        this.crrntServers = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        java.util.Vector<?> crrntServers = this.getCrrntServers();
        if (crrntServers != null) {
            ViewObject.resolveVectorProxies(crrntServers, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
