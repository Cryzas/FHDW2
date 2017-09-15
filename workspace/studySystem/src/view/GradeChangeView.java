package view;

import view.objects.*;

import view.visitor.*;

public interface GradeChangeView extends Anything, AbstractViewRoot {
    
    public GradeView getFromGrade()throws ModelException;
    public void setFromGrade(GradeView newValue) throws ModelException ;
    public GradeView getToGrade()throws ModelException;
    public void setToGrade(GradeView newValue) throws ModelException ;
    public java.util.Date getDateOfChange()throws ModelException;
    public void setDateOfChange(java.util.Date newValue) throws ModelException ;
    public String getComment()throws ModelException;
    public void setComment(String newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

