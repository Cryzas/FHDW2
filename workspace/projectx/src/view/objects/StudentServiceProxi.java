package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudentServiceProxi extends ServiceProxi implements StudentServiceView{
    
    public StudentServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudentServiceView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String username = (String)resultTable.get("username");
        java.util.Vector<String> parentServer_string = (java.util.Vector<String>)resultTable.get("parentServer");
        java.util.Vector<ServerView> parentServer = ViewProxi.getProxiVector(parentServer_string, connectionKey);
        java.util.Vector<String> errors_string = (java.util.Vector<String>)resultTable.get("errors");
        java.util.Vector<ErrorDisplayView> errors = ViewProxi.getProxiVector(errors_string, connectionKey);
        ViewProxi student = null;
        String student$String = (String)resultTable.get("student");
        if (student$String != null) {
            common.ProxiInformation student$Info = common.RPCConstantsAndServices.createProxiInformation(student$String);
            student = view.objects.ViewProxi.createProxi(student$Info,connectionKey);
            student.setToString(student$Info.getToString());
        }
        StudentServiceView result$$ = new StudentService((String)username,parentServer,errors,(StudentView)student, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getStudent() != null) return new StudentStudentServiceWrapper(this, originalIndex, (ViewRoot)this.getStudent());
        if(this.getStudent() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getStudent() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getStudent() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getStudent() != null && this.getStudent().equals(child)) return result;
        if(this.getStudent() != null) result = result + 1;
        return -1;
    }
    
    public StudentView getStudent()throws ModelException{
        return ((StudentService)this.getTheObject()).getStudent();
    }
    
    public void accept(ServiceVisitor visitor) throws ModelException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentService(this);
    }
    public <E extends view.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends view.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentService(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentService(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentService(this);
    }
    public void accept(RemoteVisitor visitor) throws ModelException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentService(this);
    }
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentService(this);
    }
    
    
    public StudentServiceConnection connectStudentService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        StudentServiceConnection result;
		try {
			result = (StudentServiceConnection) new StudentServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }public boolean hasTransientFields(){
        return true;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
