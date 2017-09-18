package view.objects;

import view.*;
import viewClient.*;

public abstract class subAdminServiceProxi extends ViewProxi implements subAdminServiceView{
    
    public subAdminServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public AdminServiceView getParentService()throws ModelException{
        return ((subAdminService)this.getTheObject()).getParentService();
    }
    public void setParentService(AdminServiceView newValue) throws ModelException {
        ((subAdminService)this.getTheObject()).setParentService(newValue);
    }
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException{
        return ((subAdminService)this.getTheObject()).getErrors();
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        ((subAdminService)this.getTheObject()).setErrors(newValue);
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
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
