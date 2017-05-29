package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class FileSystemProxi extends ViewProxi implements FileSystemView{
    
    public FileSystemProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public FileSystemView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi systemRoot = null;
        String systemRoot$String = (String)resultTable.get("systemRoot");
        if (systemRoot$String != null) {
            common.ProxiInformation systemRoot$Info = common.RPCConstantsAndServices.createProxiInformation(systemRoot$String);
            systemRoot = view.objects.ViewProxi.createProxi(systemRoot$Info,connectionKey);
            systemRoot.setToString(systemRoot$Info.getToString());
        }
        ViewProxi clipBoard = null;
        String clipBoard$String = (String)resultTable.get("clipBoard");
        if (clipBoard$String != null) {
            common.ProxiInformation clipBoard$Info = common.RPCConstantsAndServices.createProxiInformation(clipBoard$String);
            clipBoard = view.objects.ViewProxi.createProxi(clipBoard$Info,connectionKey);
            clipBoard.setToString(clipBoard$Info.getToString());
        }
        FileSystemView result$$ = new FileSystem((DirectoryView)systemRoot,(ClipBoardView)clipBoard, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getSystemRoot() != null) return new SystemRootFileSystemWrapper(this, originalIndex, (ViewRoot)this.getSystemRoot());
        if(this.getSystemRoot() != null) index = index - 1;
        if(index == 0 && this.getClipBoard() != null) return new ClipBoardFileSystemWrapper(this, originalIndex, (ViewRoot)this.getClipBoard());
        if(this.getClipBoard() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSystemRoot() == null ? 0 : 1)
            + (this.getClipBoard() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSystemRoot() == null ? true : false)
            && (this.getClipBoard() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSystemRoot() != null && this.getSystemRoot().equals(child)) return result;
        if(this.getSystemRoot() != null) result = result + 1;
        if(this.getClipBoard() != null && this.getClipBoard().equals(child)) return result;
        if(this.getClipBoard() != null) result = result + 1;
        return -1;
    }
    
    public DirectoryView getSystemRoot()throws ModelException{
        return ((FileSystem)this.getTheObject()).getSystemRoot();
    }
    public void setSystemRoot(DirectoryView newValue) throws ModelException {
        ((FileSystem)this.getTheObject()).setSystemRoot(newValue);
    }
    public ClipBoardView getClipBoard()throws ModelException{
        return ((FileSystem)this.getTheObject()).getClipBoard();
    }
    public void setClipBoard(ClipBoardView newValue) throws ModelException {
        ((FileSystem)this.getTheObject()).setClipBoard(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFileSystem(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFileSystem(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFileSystem(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFileSystem(this);
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
