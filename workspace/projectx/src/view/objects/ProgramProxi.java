package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ProgramProxi extends ViewProxi implements ProgramView{
    
    public ProgramProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ProgramView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> modules_string = (java.util.Vector<String>)resultTable.get("modules");
        java.util.Vector<ModuleAbstractView> modules = ViewProxi.getProxiVector(modules_string, connectionKey);
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi gradeSystem = null;
        String gradeSystem$String = (String)resultTable.get("gradeSystem");
        if (gradeSystem$String != null) {
            common.ProxiInformation gradeSystem$Info = common.RPCConstantsAndServices.createProxiInformation(gradeSystem$String);
            gradeSystem = view.objects.ViewProxi.createProxi(gradeSystem$Info,connectionKey);
            gradeSystem.setToString(gradeSystem$Info.getToString());
        }
        ProgramView result$$ = new Program(modules,(String)name,(common.Fraction)creditPoints,(GradeSystemView)gradeSystem, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModules().size()) return new ModulesProgramWrapper(this, originalIndex, (ViewRoot)this.getModules().get(index));
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
    
    public java.util.Vector<ModuleAbstractView> getModules()throws ModelException{
        return ((Program)this.getTheObject()).getModules();
    }
    public void setModules(java.util.Vector<ModuleAbstractView> newValue) throws ModelException {
        ((Program)this.getTheObject()).setModules(newValue);
    }
    public String getName()throws ModelException{
        return ((Program)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Program)this.getTheObject()).setName(newValue);
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return ((Program)this.getTheObject()).getCreditPoints();
    }
    public GradeSystemView getGradeSystem()throws ModelException{
        return ((Program)this.getTheObject()).getGradeSystem();
    }
    public void setGradeSystem(GradeSystemView newValue) throws ModelException {
        ((Program)this.getTheObject()).setGradeSystem(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProgram(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgram(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgram(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgram(this);
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
