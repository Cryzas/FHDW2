package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleGroupStudentProxi extends ModuleAbstractStudentProxi implements ModuleGroupStudentView{
    
    public ModuleGroupStudentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleGroupStudentView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi moduleCopy = null;
        String moduleCopy$String = (String)resultTable.get("moduleCopy");
        if (moduleCopy$String != null) {
            common.ProxiInformation moduleCopy$Info = common.RPCConstantsAndServices.createProxiInformation(moduleCopy$String);
            moduleCopy = view.objects.ViewProxi.createProxi(moduleCopy$Info,connectionKey);
            moduleCopy.setToString(moduleCopy$Info.getToString());
        }
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        java.util.Vector<String> modules_string = (java.util.Vector<String>)resultTable.get("modules");
        java.util.Vector<ModuleAbstractStudentView> modules = ViewProxi.getProxiVector(modules_string, connectionKey);
        ViewProxi grade = null;
        String grade$String = (String)resultTable.get("grade");
        if (grade$String != null) {
            common.ProxiInformation grade$Info = common.RPCConstantsAndServices.createProxiInformation(grade$String);
            grade = view.objects.ViewProxi.createProxi(grade$Info,connectionKey);
            grade.setToString(grade$Info.getToString());
        }
        ModuleGroupStudentView result$$ = new ModuleGroupStudent((ModuleAbstractSGroupView)moduleCopy,(String)name,(common.Fraction)creditPoints,modules,(GradesInTenthView)grade, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModules().size()) return new ModulesModuleGroupStudentWrapper(this, originalIndex, (ViewRoot)this.getModules().get(index));
        index = index - this.getModules().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModules().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getModules().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModulesIterator = this.getModules().iterator();
        while(getModulesIterator.hasNext()){
            if(getModulesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<ModuleAbstractStudentView> getModules()throws ModelException{
        return ((ModuleGroupStudent)this.getTheObject()).getModules();
    }
    public void setModules(java.util.Vector<ModuleAbstractStudentView> newValue) throws ModelException {
        ((ModuleGroupStudent)this.getTheObject()).setModules(newValue);
    }
    public GradesInTenthView getGrade()throws ModelException{
        return ((ModuleGroupStudent)this.getTheObject()).getGrade();
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws ModelException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleGroupStudent(this);
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
