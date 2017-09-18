package view;

import viewClient.*;

import view.objects.*;

import view.visitor.*;

public interface subAdminServiceView extends Anything, Remote, AbstractViewRoot {
    
    public AdminServiceView getParentService()throws ModelException;
    public void setParentService(AdminServiceView newValue) throws ModelException ;
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException;
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException ;
    
    public void accept(subAdminServiceVisitor visitor) throws ModelException;
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public subAdminServiceConnection connectsubAdminService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

