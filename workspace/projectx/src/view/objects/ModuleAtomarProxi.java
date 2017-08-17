package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleAtomarProxi extends ModuleAbstractProxi implements ModuleAtomarView{
    
    public ModuleAtomarProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public ModuleAtomarView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi gradeSystem = null;
        String gradeSystem$String = (String)resultTable.get("gradeSystem");
        if (gradeSystem$String != null) {
            common.ProxiInformation gradeSystem$Info = common.RPCConstantsAndServices.createProxiInformation(gradeSystem$String);
            gradeSystem = view.objects.ViewProxi.createProxi(gradeSystem$Info,connectionKey);
            gradeSystem.setToString(gradeSystem$Info.getToString());
        }
        ModuleAtomarView result$$ = new ModuleAtomar((String)name,(common.Fraction)creditPoints,(GradeSystemView)gradeSystem, this.getId(), this.getClassId());
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
    
    
    public void accept(ModuleAbstractVisitor visitor) throws ModelException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomar(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomar(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
