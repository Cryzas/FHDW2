
package view.objects;

import view.*;
import viewClient.*;
import view.visitor.*;


/* Additional import section end */

public class StudyGroupService extends view.objects.subAdminService implements StudyGroupServiceView{
    
    protected StudyGroupManagerView groupManager;
    
    public StudyGroupService(AdminServiceView parentService,java.util.Vector<ErrorDisplayView> errors,StudyGroupManagerView groupManager,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AdminServiceView)parentService,errors,id, classId);
        this.groupManager = groupManager;        
    }
    
    static public long getTypeId() {
        return -302;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public StudyGroupManagerView getGroupManager()throws ModelException{
        return this.groupManager;
    }
    public void setGroupManager(StudyGroupManagerView newValue) throws ModelException {
        this.groupManager = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AdminServiceView parentService = this.getParentService();
        if (parentService != null) {
            ((ViewProxi)parentService).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(parentService.getClassId(), parentService.getId())));
        }
        java.util.Vector<?> errors = this.getErrors();
        if (errors != null) {
            ViewObject.resolveVectorProxies(errors, resultTable);
        }
        StudyGroupManagerView groupManager = this.getGroupManager();
        if (groupManager != null) {
            ((ViewProxi)groupManager).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(groupManager.getClassId(), groupManager.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
        return true 
            && (this.getGroupManager() == null ? true : this.getGroupManager().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getGroupManager() != null && this.getGroupManager().equals(child)) return result;
        if(this.getGroupManager() != null) result = result + 1;
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
