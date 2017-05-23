package view;

import view.visitor.*;

public interface AccountView extends abstractAccView {
    
    public FolderView getInBox()throws ModelException;
    public void setInBox(FolderView newValue) throws ModelException ;
    public FolderView getOutBox()throws ModelException;
    public void setOutBox(FolderView newValue) throws ModelException ;
    public FolderView getDrafts()throws ModelException;
    public void setDrafts(FolderView newValue) throws ModelException ;
    public java.util.Vector<FolderView> getFolders()throws ModelException;
    public void setFolders(java.util.Vector<FolderView> newValue) throws ModelException ;
    
    public void accept(abstractAccVisitor visitor) throws ModelException;
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

