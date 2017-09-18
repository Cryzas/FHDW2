package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudentManageServiceProxi extends subAdminServiceProxi implements StudentManageServiceView{
    
    public StudentManageServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudentManageServiceView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi parentService = null;
        String parentService$String = (String)resultTable.get("parentService");
        if (parentService$String != null) {
            common.ProxiInformation parentService$Info = common.RPCConstantsAndServices.createProxiInformation(parentService$String);
            parentService = view.objects.ViewProxi.createProxi(parentService$Info,connectionKey);
            parentService.setToString(parentService$Info.getToString());
        }
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi studentManager = null;
        String studentManager$String = (String)resultTable.get("studentManager");
        if (studentManager$String != null) {
            common.ProxiInformation studentManager$Info = common.RPCConstantsAndServices.createProxiInformation(studentManager$String);
            studentManager = view.objects.ViewProxi.createProxi(studentManager$Info,connectionKey);
            studentManager.setToString(studentManager$Info.getToString());
        }
        StudentManageServiceView result$$ = new StudentManageService((AdminServiceView)parentService,errors,(StudentManagerView)studentManager, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getStudentManager() != null && index < this.getStudentManager().getTheObject().getChildCount())
            return this.getStudentManager().getTheObject().getChild(index);
        if(this.getStudentManager() != null) index = index - this.getStudentManager().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getStudentManager() == null ? 0 : this.getStudentManager().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getStudentManager() == null ? true : this.getStudentManager().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getStudentManager() != null && this.getStudentManager().equals(child)) return result;
        if(this.getStudentManager() != null) result = result + 1;
        return -1;
    }
    
    public StudentManagerView getStudentManager()throws ModelException{
        return ((StudentManageService)this.getTheObject()).getStudentManager();
    }
    public void setStudentManager(StudentManagerView newValue) throws ModelException {
        ((StudentManageService)this.getTheObject()).setStudentManager(newValue);
    }
    
    public void accept(subAdminServiceVisitor visitor) throws ModelException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends view.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends view.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentManageService(this);
    }
    
    
    public StudentManageServiceConnection connectStudentManageService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        StudentManageServiceConnection result;
		try {
			result = (StudentManageServiceConnection) new StudentManageServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
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
