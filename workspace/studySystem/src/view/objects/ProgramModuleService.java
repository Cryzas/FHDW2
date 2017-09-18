
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class ProgramModuleService extends view.objects.subAdminService implements ProgramModuleServiceView{
    
    protected ProgramManagerView programManager;
    protected ModuleManagerView moduleManager;
    
    public ProgramModuleService(AdminServiceView parentService,java.util.Vector<ErrorDisplayView> errors,ProgramManagerView programManager,ModuleManagerView moduleManager,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AdminServiceView)parentService,errors,id, classId);
        this.programManager = programManager;
        this.moduleManager = moduleManager;        
    }
    
    static public long getTypeId() {
        return -305;
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
    
    public void accept(subAdminServiceVisitor visitor) throws ModelException {
        visitor.handleProgramModuleService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgramModuleService(this);
    }
    public <E extends view.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgramModuleService(this);
    }
    public <R, E extends view.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgramModuleService(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProgramModuleService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgramModuleService(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgramModuleService(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgramModuleService(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleProgramModuleService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgramModuleService(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgramModuleService(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgramModuleService(this);
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
        ProgramManagerView programManager = this.getProgramManager();
        if (programManager != null) {
            ((ViewProxi)programManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(programManager.getClassId(), programManager.getId())));
        }
        ModuleManagerView moduleManager = this.getModuleManager();
        if (moduleManager != null) {
            ((ViewProxi)moduleManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(moduleManager.getClassId(), moduleManager.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getProgramManager() != null) return new ProgramManagerProgramModuleServiceWrapper(this, originalIndex, (ViewRoot)this.getProgramManager());
        if(this.getProgramManager() != null) index = index - 1;
        if(index == 0 && this.getModuleManager() != null) return new ModuleManagerProgramModuleServiceWrapper(this, originalIndex, (ViewRoot)this.getModuleManager());
        if(this.getModuleManager() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProgramManager() == null ? 0 : 1)
            + (this.getModuleManager() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProgramManager() == null ? true : false)
            && (this.getModuleManager() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProgramManager() != null && this.getProgramManager().equals(child)) return result;
        if(this.getProgramManager() != null) result = result + 1;
        if(this.getModuleManager() != null && this.getModuleManager().equals(child)) return result;
        if(this.getModuleManager() != null) result = result + 1;
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
    public ProgramModuleServiceConnection connectProgramModuleService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        ProgramModuleServiceConnection result;
		try {
			result = (ProgramModuleServiceConnection) new ProgramModuleServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
