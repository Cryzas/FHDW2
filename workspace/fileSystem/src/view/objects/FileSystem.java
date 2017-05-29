
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class FileSystem extends ViewObject implements FileSystemView{
    
    protected DirectoryView systemRoot;
    protected ClipBoardView clipBoard;
    
    public FileSystem(DirectoryView systemRoot,ClipBoardView clipBoard,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.systemRoot = systemRoot;
        this.clipBoard = clipBoard;        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public DirectoryView getSystemRoot()throws ModelException{
        return this.systemRoot;
    }
    public void setSystemRoot(DirectoryView newValue) throws ModelException {
        this.systemRoot = newValue;
    }
    public ClipBoardView getClipBoard()throws ModelException{
        return this.clipBoard;
    }
    public void setClipBoard(ClipBoardView newValue) throws ModelException {
        this.clipBoard = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        DirectoryView systemRoot = this.getSystemRoot();
        if (systemRoot != null) {
            ((ViewProxi)systemRoot).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(systemRoot.getClassId(), systemRoot.getId())));
        }
        ClipBoardView clipBoard = this.getClipBoard();
        if (clipBoard != null) {
            ((ViewProxi)clipBoard).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(clipBoard.getClassId(), clipBoard.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
