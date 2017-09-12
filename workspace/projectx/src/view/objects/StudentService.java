
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class StudentService extends view.objects.Service implements StudentServiceView{
    
    protected StudentView student;
    
    public StudentService(String username,java.util.Vector<ServerView> parentServer,java.util.Vector<ErrorDisplayView> errors,StudentView student,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)username,parentServer,errors,id, classId);
        this.student = student;        
    }
    
    static public long getTypeId() {
        return -286;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public StudentView getStudent()throws ModelException{
        return this.student;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> parentServer = this.getParentServer();
        if (parentServer != null) {
            ViewObject.resolveVectorProxies(parentServer, resultTable);
        }
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        StudentView student = this.getStudent();
        if (student != null) {
            ((ViewProxi)student).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(student.getClassId(), student.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
        return true 
            && (this.getStudent() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getStudent() != null && this.getStudent().equals(child)) return result;
        if(this.getStudent() != null) result = result + 1;
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
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
