package view;

import viewClient.*;

import view.visitor.*;

public interface StudentManageServiceView extends subAdminServiceView {
    
    public StudentManagerView getStudentManager()throws ModelException;
    public void setStudentManager(StudentManagerView newValue) throws ModelException ;
    
    public void accept(subAdminServiceVisitor visitor) throws ModelException;
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(RemoteVisitor visitor) throws ModelException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public StudentManageServiceConnection connectStudentManageService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

