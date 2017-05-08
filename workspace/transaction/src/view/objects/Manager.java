
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Manager extends ViewObject implements ManagerView{
    
    protected java.util.Vector<AccountView> currentAccounts;
    protected java.util.Vector<TransferView> openTransfers;
    
    public Manager(java.util.Vector<AccountView> currentAccounts,java.util.Vector<TransferView> openTransfers,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.currentAccounts = currentAccounts;
        this.openTransfers = openTransfers;        
    }
    
    static public long getTypeId() {
        return 135;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<AccountView> getCurrentAccounts()throws ModelException{
        return this.currentAccounts;
    }
    public void setCurrentAccounts(java.util.Vector<AccountView> newValue) throws ModelException {
        this.currentAccounts = newValue;
    }
    public java.util.Vector<TransferView> getOpenTransfers()throws ModelException{
        return this.openTransfers;
    }
    public void setOpenTransfers(java.util.Vector<TransferView> newValue) throws ModelException {
        this.openTransfers = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> currentAccounts = this.getCurrentAccounts();
        if (currentAccounts != null) {
            ViewObject.resolveVectorProxies(currentAccounts, resultTable);
        }
        java.util.Vector<?> openTransfers = this.getOpenTransfers();
        if (openTransfers != null) {
            ViewObject.resolveVectorProxies(openTransfers, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCurrentAccounts().size()) return new CurrentAccountsManagerWrapper(this, originalIndex, (ViewRoot)this.getCurrentAccounts().get(index));
        index = index - this.getCurrentAccounts().size();
        if(index < this.getOpenTransfers().size()) return new OpenTransfersManagerWrapper(this, originalIndex, (ViewRoot)this.getOpenTransfers().get(index));
        index = index - this.getOpenTransfers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCurrentAccounts().size())
            + (this.getOpenTransfers().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getCurrentAccounts().size() == 0)
            && (this.getOpenTransfers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCurrentAccountsIterator = this.getCurrentAccounts().iterator();
        while(getCurrentAccountsIterator.hasNext()){
            if(getCurrentAccountsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getOpenTransfersIterator = this.getOpenTransfers().iterator();
        while(getOpenTransfersIterator.hasNext()){
            if(getOpenTransfersIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
