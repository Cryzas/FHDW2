
package view.objects;

import view.*;
import viewClient.*;


/* Additional import section end */

public abstract class subAdminService extends ViewObject implements subAdminServiceView{
    
    protected AdminServiceView parentService;
    protected java.util.Vector<ErrorDisplayView> errors;
    
    public subAdminService(AdminServiceView parentService,java.util.Vector<ErrorDisplayView> errors,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.parentService = parentService;
        this.errors = errors;        
    }
    
    public AdminServiceView getParentService()throws ModelException{
        return this.parentService;
    }
    public void setParentService(AdminServiceView newValue) throws ModelException {
        this.parentService = newValue;
    }
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException{
        return this.errors;
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        this.errors = newValue;
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
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
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
    public subAdminServiceConnection connectsubAdminService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        subAdminServiceConnection result;
		try {
			result = (subAdminServiceConnection) new subAdminServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }
    
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
