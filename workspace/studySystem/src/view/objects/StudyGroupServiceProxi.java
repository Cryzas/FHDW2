package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudyGroupServiceProxi extends subAdminServiceProxi implements StudyGroupServiceView{
    
    public StudyGroupServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudyGroupServiceView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi parentService = null;
        String parentService$String = (String)resultTable.get("parentService");
        if (parentService$String != null) {
            common.ProxiInformation parentService$Info = common.RPCConstantsAndServices.createProxiInformation(parentService$String);
            parentService = view.objects.ViewProxi.createProxi(parentService$Info,connectionKey);
            parentService.setToString(parentService$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi groupManager = null;
        String groupManager$String = (String)resultTable.get("groupManager");
        if (groupManager$String != null) {
            common.ProxiInformation groupManager$Info = common.RPCConstantsAndServices.createProxiInformation(groupManager$String);
            groupManager = view.objects.ViewProxi.createProxi(groupManager$Info,connectionKey);
            groupManager.setToString(groupManager$Info.getToString());
        }
        StudyGroupServiceView result$$ = new StudyGroupService((AdminServiceView)parentService,errors,(StudyGroupManagerView)groupManager, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getGroupManager() != null && index < this.getGroupManager().getTheObject().getChildCount())
            return this.getGroupManager().getTheObject().getChild(index);
        if(this.getGroupManager() != null) index = index - this.getGroupManager().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getGroupManager() == null ? 0 : this.getGroupManager().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getGroupManager() == null ? true : this.getGroupManager().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getGroupManager() != null && this.getGroupManager().equals(child)) return result;
        if(this.getGroupManager() != null) result = result + 1;
        return -1;
    }
    
    public StudyGroupManagerView getGroupManager()throws ModelException{
        return ((StudyGroupService)this.getTheObject()).getGroupManager();
    }
    public void setGroupManager(StudyGroupManagerView newValue) throws ModelException {
        ((StudyGroupService)this.getTheObject()).setGroupManager(newValue);
    }
    
    public void accept(subAdminServiceVisitor visitor) throws ModelException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends view.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends view.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroupService(this);
    }
    
    
    public StudyGroupServiceConnection connectStudyGroupService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        StudyGroupServiceConnection result;
		try {
			result = (StudyGroupServiceConnection) new StudyGroupServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
