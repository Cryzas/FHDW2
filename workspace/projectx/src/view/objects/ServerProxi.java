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
        ViewProxi groupManager = null;
        String groupManager$String = (String)resultTable.get("groupManager");
        if (groupManager$String != null) {
            common.ProxiInformation groupManager$Info = common.RPCConstantsAndServices.createProxiInformation(groupManager$String);
            groupManager = view.objects.ViewProxi.createProxi(groupManager$Info,connectionKey);
            groupManager.setToString(groupManager$Info.getToString());
        }
        ViewProxi studentManager = null;
        String studentManager$String = (String)resultTable.get("studentManager");
        if (studentManager$String != null) {
            common.ProxiInformation studentManager$Info = common.RPCConstantsAndServices.createProxiInformation(studentManager$String);
            studentManager = view.objects.ViewProxi.createProxi(studentManager$Info,connectionKey);
            studentManager.setToString(studentManager$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        String user = (String)resultTable.get("user");
        ServerView result$$ = new Server((ProgramManagerView)programManager,(ModuleManagerView)moduleManager,(StudyGroupManagerView)groupManager,(StudentManagerView)studentManager,errors,(String)user, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getProgramManager() != null) return new ProgramManagerServerWrapper(this, originalIndex, (ViewRoot)this.getProgramManager());
        if(this.getProgramManager() != null) index = index - 1;
        if(index == 0 && this.getModuleManager() != null) return new ModuleManagerServerWrapper(this, originalIndex, (ViewRoot)this.getModuleManager());
        if(this.getModuleManager() != null) index = index - 1;
        if(index == 0 && this.getGroupManager() != null) return new GroupManagerServerWrapper(this, originalIndex, (ViewRoot)this.getGroupManager());
        if(this.getGroupManager() != null) index = index - 1;
        if(index == 0 && this.getStudentManager() != null) return new StudentManagerServerWrapper(this, originalIndex, (ViewRoot)this.getStudentManager());
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public ProgramManagerView getProgramManager()throws ModelException{
        return ((Server)this.getTheObject()).getProgramManager();
    }
    public void setProgramManager(ProgramManagerView newValue) throws ModelException {
        ((Server)this.getTheObject()).setProgramManager(newValue);
    }
    public ModuleManagerView getModuleManager()throws ModelException{
        return ((Server)this.getTheObject()).getModuleManager();
    }
    public void setModuleManager(ModuleManagerView newValue) throws ModelException {
        ((Server)this.getTheObject()).setModuleManager(newValue);
    }
    public StudyGroupManagerView getGroupManager()throws ModelException{
        return ((Server)this.getTheObject()).getGroupManager();
    }
    public void setGroupManager(StudyGroupManagerView newValue) throws ModelException {
        ((Server)this.getTheObject()).setGroupManager(newValue);
    }
    public StudentManagerView getStudentManager()throws ModelException{
        return ((Server)this.getTheObject()).getStudentManager();
    }
    public void setStudentManager(StudentManagerView newValue) throws ModelException {
        ((Server)this.getTheObject()).setStudentManager(newValue);
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
