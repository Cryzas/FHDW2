
package view.objects;

import view.*;
import viewClient.*;


/* Additional import section end */

public abstract class Service extends ViewObject implements ServiceView{
    
    protected String username;
    protected java.util.Vector<ServerView> parentServer;
    protected java.util.Vector<ErrorDisplayView> errors;
    
    public Service(String username,java.util.Vector<ServerView> parentServer,java.util.Vector<ErrorDisplayView> errors,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.username = username;
        this.parentServer = parentServer;
        this.errors = errors;        
    }
    
    public String getUsername()throws ModelException{
        return this.username;
    }
    public java.util.Vector<ServerView> getParentServer()throws ModelException{
        return this.parentServer;
    }
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException{
        return this.errors;
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        this.errors = newValue;
    }
    
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> parentServer = this.getParentServer();
        if (parentServer != null) {
            ViewObject.resolveVectorProxies(parentServer, resultTable);
        }
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
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
    public ServiceConnection connectService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        ServiceConnection result;
		try {
			result = (ServiceConnection) new ServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }
    
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
