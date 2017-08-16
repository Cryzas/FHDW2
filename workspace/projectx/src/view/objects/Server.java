
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class Server extends ViewObject implements ServerView{
    
    protected ProgramManagerView programManager;
    protected ModuleManagerView moduleManager;
    protected StudyGroupManagerView groupManager;
    protected java.util.Vector<ErrorDisplayView> errors;
    protected String user;
    
    public Server(ProgramManagerView programManager,ModuleManagerView moduleManager,StudyGroupManagerView groupManager,java.util.Vector<ErrorDisplayView> errors,String user,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.programManager = programManager;
        this.moduleManager = moduleManager;
        this.groupManager = groupManager;
        this.errors = errors;
        this.user = user;        
    }
    
    static public long getTypeId() {
        return -102;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ProgramManagerView getProgramManager()throws ModelException{
        return this.programManager;
    }
    public void setProgramManager(ProgramManagerView newValue) throws ModelException {
        this.programManager = newValue;
    }
    public ModuleManagerView getModuleManager()throws ModelException{
        return this.moduleManager;
    }
    public void setModuleManager(ModuleManagerView newValue) throws ModelException {
        this.moduleManager = newValue;
    }
    public StudyGroupManagerView getGroupManager()throws ModelException{
        return this.groupManager;
    }
    public void setGroupManager(StudyGroupManagerView newValue) throws ModelException {
        this.groupManager = newValue;
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
        ProgramManagerView programManager = this.getProgramManager();
        if (programManager != null) {
            ((ViewProxi)programManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(programManager.getClassId(), programManager.getId())));
        }
        ModuleManagerView moduleManager = this.getModuleManager();
        if (moduleManager != null) {
            ((ViewProxi)moduleManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(moduleManager.getClassId(), moduleManager.getId())));
        }
        StudyGroupManagerView groupManager = this.getGroupManager();
        if (groupManager != null) {
            ((ViewProxi)groupManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(groupManager.getClassId(), groupManager.getId())));
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
        if(index == 0 && this.getProgramManager() != null) return new ProgramManagerServerWrapper(this, originalIndex, (ViewRoot)this.getProgramManager());
        if(this.getProgramManager() != null) index = index - 1;
        if(index == 0 && this.getModuleManager() != null) return new ModuleManagerServerWrapper(this, originalIndex, (ViewRoot)this.getModuleManager());
        if(this.getModuleManager() != null) index = index - 1;
        if(index == 0 && this.getGroupManager() != null) return new GroupManagerServerWrapper(this, originalIndex, (ViewRoot)this.getGroupManager());
        if(this.getGroupManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProgramManager() == null ? 0 : 1)
            + (this.getModuleManager() == null ? 0 : 1)
            + (this.getGroupManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProgramManager() == null ? true : false)
            && (this.getModuleManager() == null ? true : false)
            && (this.getGroupManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProgramManager() != null && this.getProgramManager().equals(child)) return result;
        if(this.getProgramManager() != null) result = result + 1;
        if(this.getModuleManager() != null && this.getModuleManager().equals(child)) return result;
        if(this.getModuleManager() != null) result = result + 1;
        if(this.getGroupManager() != null && this.getGroupManager().equals(child)) return result;
        if(this.getGroupManager() != null) result = result + 1;
        return -1;
    }
    public int getUserIndex() throws ModelException {
        return 0 + (this.getProgramManager() == null ? 0 : 1) + (this.getModuleManager() == null ? 0 : 1) + (this.getGroupManager() == null ? 0 : 1);
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
