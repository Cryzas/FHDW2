package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ProgramModuleServiceProxi extends subAdminServiceProxi implements ProgramModuleServiceView{
    
    public ProgramModuleServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ProgramModuleServiceView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi parentService = null;
        String parentService$String = (String)resultTable.get("parentService");
        if (parentService$String != null) {
            common.ProxiInformation parentService$Info = common.RPCConstantsAndServices.createProxiInformation(parentService$String);
            parentService = view.objects.ViewProxi.createProxi(parentService$Info,connectionKey);
            parentService.setToString(parentService$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi programManager = null;
        String programManager$String = (String)resultTable.get("programManager");
        if (programManager$String != null) {
            common.ProxiInformation programManager$Info = common.RPCConstantsAndServices.createProxiInformation(programManager$String);
            programManager = view.objects.ViewProxi.createProxi(programManager$Info,connectionKey);
            programManager.setToString(programManager$Info.getToString());
        }
        ViewProxi moduleManager = null;
        String moduleManager$String = (String)resultTable.get("moduleManager");
        if (moduleManager$String != null) {
            common.ProxiInformation moduleManager$Info = common.RPCConstantsAndServices.createProxiInformation(moduleManager$String);
            moduleManager = view.objects.ViewProxi.createProxi(moduleManager$Info,connectionKey);
            moduleManager.setToString(moduleManager$Info.getToString());
        }
        ProgramModuleServiceView result$$ = new ProgramModuleService((AdminServiceView)parentService,errors,(ProgramManagerView)programManager,(ModuleManagerView)moduleManager, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public ProgramManagerView getProgramManager()throws ModelException{
        return ((ProgramModuleService)this.getTheObject()).getProgramManager();
    }
    public void setProgramManager(ProgramManagerView newValue) throws ModelException {
        ((ProgramModuleService)this.getTheObject()).setProgramManager(newValue);
    }
    public ModuleManagerView getModuleManager()throws ModelException{
        return ((ProgramModuleService)this.getTheObject()).getModuleManager();
    }
    public void setModuleManager(ModuleManagerView newValue) throws ModelException {
        ((ProgramModuleService)this.getTheObject()).setModuleManager(newValue);
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
