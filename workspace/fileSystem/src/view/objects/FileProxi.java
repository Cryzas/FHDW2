package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class FileProxi extends ContaineeProxi implements FileView{
    
    public FileProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public FileView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        String contents = (String)resultTable.get("contents");
        FileView result$$ = new File((String)name,(String)contents, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
    
    public String getContents()throws ModelException{
        return ((File)this.getTheObject()).getContents();
    }
    public void setContents(String newValue) throws ModelException {
        ((File)this.getTheObject()).setContents(newValue);
    }
    
    public void accept(ContaineeVisitor visitor) throws ModelException {
        visitor.handleFile(this);
    }
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFile(this);
    }
    public <E extends view.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFile(this);
    }
    public <R, E extends view.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFile(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFile(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFile(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFile(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFile(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
