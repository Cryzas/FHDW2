package view;

import view.visitor.*;

public interface FileView extends ContaineeView {
    
    public String getContents()throws ModelException;
    public void setContents(String newValue) throws ModelException ;
    
    public void accept(ContaineeVisitor visitor) throws ModelException;
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

