package view;

import view.visitor.*;

public interface ModuleGroupStudentView extends ModuleAbstractStudentView {
    
    public java.util.Vector<ModuleAbstractStudentView> getModules()throws ModelException;
    public void setModules(java.util.Vector<ModuleAbstractStudentView> newValue) throws ModelException ;
    public GradesInTenthView getGrade()throws ModelException;
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws ModelException;
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

