package view;

import view.visitor.*;

public interface GradesInTenthView extends GradeView {
    
    
    public void accept(GradesInTenthVisitor visitor) throws ModelException;
    public <R> R accept(GradesInTenthReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInTenthExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInTenthReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

