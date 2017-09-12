
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class DozentenService extends view.objects.Service implements DozentenServiceView{
    
    protected ProgramManagerView programManager;
    protected ModuleManagerView moduleManager;
    protected StudyGroupManagerView groupManager;
    protected StudentManagerView studentManager;
    
    public DozentenService(String username,java.util.Vector<ServerView> parentServer,java.util.Vector<ErrorDisplayView> errors,ProgramManagerView programManager,ModuleManagerView moduleManager,StudyGroupManagerView groupManager,StudentManagerView studentManager,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)username,parentServer,errors,id, classId);
        this.programManager = programManager;
        this.moduleManager = moduleManager;
        this.groupManager = groupManager;
        this.studentManager = studentManager;        
    }
    
    static public long getTypeId() {
        return -287;
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
    public StudentManagerView getStudentManager()throws ModelException{
        return this.studentManager;
    }
    public void setStudentManager(StudentManagerView newValue) throws ModelException {
        this.studentManager = newValue;
    }
    
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleDozentenService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDozentenService(this);
    }
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDozentenService(this);
    }
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDozentenService(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDozentenService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDozentenService(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDozentenService(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDozentenService(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleDozentenService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDozentenService(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDozentenService(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDozentenService(this);
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
        StudentManagerView studentManager = this.getStudentManager();
        if (studentManager != null) {
            ((ViewProxi)studentManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(studentManager.getClassId(), studentManager.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getProgramManager() != null) return new ProgramManagerDozentenServiceWrapper(this, originalIndex, (ViewRoot)this.getProgramManager());
        if(this.getProgramManager() != null) index = index - 1;
        if(index == 0 && this.getModuleManager() != null) return new ModuleManagerDozentenServiceWrapper(this, originalIndex, (ViewRoot)this.getModuleManager());
        if(this.getModuleManager() != null) index = index - 1;
        if(index == 0 && this.getGroupManager() != null) return new GroupManagerDozentenServiceWrapper(this, originalIndex, (ViewRoot)this.getGroupManager());
        if(this.getGroupManager() != null) index = index - 1;
        if(index == 0 && this.getStudentManager() != null) return new StudentManagerDozentenServiceWrapper(this, originalIndex, (ViewRoot)this.getStudentManager());
        if(this.getStudentManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProgramManager() == null ? 0 : 1)
            + (this.getModuleManager() == null ? 0 : 1)
            + (this.getGroupManager() == null ? 0 : 1)
            + (this.getStudentManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProgramManager() == null ? true : false)
            && (this.getModuleManager() == null ? true : false)
            && (this.getGroupManager() == null ? true : false)
            && (this.getStudentManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProgramManager() != null && this.getProgramManager().equals(child)) return result;
        if(this.getProgramManager() != null) result = result + 1;
        if(this.getModuleManager() != null && this.getModuleManager().equals(child)) return result;
        if(this.getModuleManager() != null) result = result + 1;
        if(this.getGroupManager() != null && this.getGroupManager().equals(child)) return result;
        if(this.getGroupManager() != null) result = result + 1;
        if(this.getStudentManager() != null && this.getStudentManager().equals(child)) return result;
        if(this.getStudentManager() != null) result = result + 1;
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
    public DozentenServiceConnection connectDozentenService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        DozentenServiceConnection result;
		try {
			result = (DozentenServiceConnection) new DozentenServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
