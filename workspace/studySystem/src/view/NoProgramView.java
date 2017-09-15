package view;

import view.visitor.*;

public interface NoProgramView extends ProgramStudentView {
    
    
    public void accept(ProgramStudentVisitor visitor) throws ModelException;
    public <R> R accept(ProgramStudentReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ProgramStudentExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ProgramStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

