package view.objects;


import view.ModelException;

import viewClient.ExceptionAndEventHandler;
import viewClient.ConnectionMaster;
import viewClient.ConnectionIndex;

import common.RPCConstantsAndServices;
import common.ProxiInformation;

import java.util.Vector;
import java.util.Iterator;

import javax.swing.event.TableModelListener;
import javax.swing.tree.TreePath;

abstract class ProxiFactory {
	  abstract ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey);
}

public abstract class ViewProxi extends ViewRoot {

  @SuppressWarnings("unchecked")
  public static <T> Vector<T> getProxiVector(Vector<String> hashtableVector, ExceptionAndEventHandler connectionKey) throws ModelException {
	Vector<T> result = new Vector<T>();
    Iterator<String> entries = hashtableVector.iterator();
    while (entries.hasNext()){
      String current = (String)entries.next();
      ProxiInformation currentProxiInformation = RPCConstantsAndServices.createProxiInformation(current);
      ViewProxi currentProxi = ViewProxi.createProxi(currentProxiInformation, connectionKey);
      currentProxi.setToString(currentProxiInformation.getToString());
      currentProxi.setIconInfo(currentProxiInformation.getIconInfo());
      currentProxi.setLeafInfo(currentProxiInformation.getLeafInfo());
      
      result.add((T) currentProxi);
    }
    return result;
  }
    
  public static ViewProxi createProxi(ProxiInformation proxi, ExceptionAndEventHandler connectionKey) throws ModelException{
	  ViewProxi result = createProxi(proxi.getObjectId(), proxi.getClassId(), connectionKey);
	  if (proxi.isDecorator()){
		  ViewDecoratorProxi resultAsDecorator = (ViewDecoratorProxi) result;
		  resultAsDecorator.setDecorateeId(proxi.getDecorateeObjectId());
		  resultAsDecorator.setDecorateeClassId(proxi.getDecorateeClassId());
	  }
	  result.setIconInfo(proxi.getIconInfo());
	  result.setLeafInfo(proxi.getLeafInfo());
	  return result;
  }

  private static ProxiFactory [] proxiFactories;
	
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [173];
        proxiFactories[1] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ServerProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[76] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ProgramSGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[77] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleGroupSGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[78] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleAtomarSGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[52] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleAtomarProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[124] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_3_7Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[111] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ThirdGradeSystemProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[79] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudyGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[125] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[126] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_1Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[128] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_2Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[130] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_2Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[131] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_3Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[132] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_4Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[133] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_5Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[134] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_6Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[135] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_7Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[136] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_8Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[137] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_9Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[100] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudentManagerProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[94] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudentProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[121] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_2_3Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[122] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_2_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[139] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_2_7Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[96] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new UnitStudentProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[81] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleWithUnitsSGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[90] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleAtomarStudentProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[53] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleWithUnitsProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[91] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ProgramStudentProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[143] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_3Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[144] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_5_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[146] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_4Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[148] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_5Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[92] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleWithUnitsStudentProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[150] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_6Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[152] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_7Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[154] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_8Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[156] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_1_9Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[93] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleGroupStudentProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[161] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_3_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[162] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_3_3Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[113] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new PassedProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ErrorDisplayProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[44] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleManagerProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[65] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ModuleGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[46] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new UnitProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[47] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ProgramManagerProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[127] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[112] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new SimpleGradeSystemProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[129] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_4_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new ProgramProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[80] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new UnitSGroupProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[138] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_4_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[85] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new StudyGroupManagerProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[172] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new NoGradeProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[118] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new NotPassedProxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[140] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[141] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_2_1Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[142] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_1Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[145] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_2Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[147] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_3Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[149] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_4Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[151] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_5Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[153] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_6Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[155] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_7Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[157] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_8Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[158] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new Z_3_9Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[160] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_5_0Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[119] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_1_3Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[123] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_1_7Proxi(objectId, classId, connectionKey);
            }
        };
        proxiFactories[120] = new ProxiFactory(){
            ViewProxi create(long objectId, long classId, ExceptionAndEventHandler connectionKey){
                return new T_1_0Proxi(objectId, classId, connectionKey);
            }
        };
	}
	return proxiFactories;
  }
	
  public static ViewProxi createProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) throws ModelException {
	if (classId == 0) return null;
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new ModelException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new ModelException("Unknown class :" + Long.toString(classId),0);
    ViewProxi result =  factory.create(objectId, classId, connectionKey);
    return result;
  }


	protected ViewObject object;

	private ExceptionAndEventHandler connectionKey;

	private boolean expanded;
	

	protected ViewProxi(long id, long classId, ExceptionAndEventHandler connectionKey) {
		super(id, classId);
		this.connectionKey = connectionKey;
		this.expanded = false;
	}
	public void setExpanded(boolean b) {
		this.expanded = true;
	}

	public boolean expand(){
		if (!expanded){
			try {
				this.getRemote(new java.util.Vector<ViewRoot>(), true);
				this.expanded = true;
			} catch (ModelException e) {
				if (e.getErrorNumber() == RPCConstantsAndServices.ObjectNotAvailableErrorNo && this.object != null){
					this.expanded = true;
					return true;
				} else {
					this.setToString(e.getMessage());
					return false;
				}
			}
		}
		return true;
	}

	public ViewObject getTheObject() throws ModelException {
		if (this.object == null)
			getRemote(new java.util.Vector<ViewRoot>(), false);
		return this.object;
	}

	public void setObject(ViewObject object) {
		this.object = object;
	}

	protected ConnectionMaster getConnection() {
		return ConnectionIndex.getTheConnectionIndex().getConnection(this.connectionKey);
	}


	@SuppressWarnings("unchecked")
	public void getRemote(java.util.Vector<ViewRoot> context, boolean forTreeView) throws ModelException {
        ConnectionMaster connection = this.getConnection();
        java.util.HashMap<Object,Object> table = connection.getObject(getRemoteDepth(), context, forTreeView, this);
        if(((Boolean)table.get("?OK?")).booleanValue()) {
            java.util.HashMap<String,Object> resultTable = (java.util.HashMap<String,Object>)table.get(RPCConstantsAndServices.ResultFieldName);
            ViewProxi.resolveReferences(resultTable, this.connectionKey);
            this.setObject((ViewObject) resultTable.get(RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId())));
        }else{
            throw new ModelException((String)table.get("?Message?"), ((Integer)table.get("?ExceptionNumber?")).intValue());
        }
    }
	@SuppressWarnings("unchecked")
	public static void resolveReferences(java.util.HashMap<String, Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        for (String current : resultTable.keySet()) {
			ProxiInformation info = RPCConstantsAndServices.createProxiInformation(current);
			ViewProxi proxi = ViewProxi.createProxi(info, connectionKey);
			resultTable.put(current, proxi.getRemoteObject((java.util.HashMap<String,Object>) resultTable.get(current), connectionKey));
		}
        for (String current : resultTable.keySet()) {
			ViewObject currentEntry = (ViewObject) resultTable.get(current);
			if (currentEntry != null)currentEntry.resolveProxies(resultTable);
		}    	
        for (String current : resultTable.keySet()) {
			ViewObject currentEntry = (ViewObject) resultTable.get(current);
			if (currentEntry != null)currentEntry.sortSetValuedFields();
		}    	
    }

	abstract protected AbstractViewRoot getRemoteObject(java.util.HashMap<String, Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException;

	public String toString() {
		try {
			return this.object == null ? this.toString : this.getTheObject().toString();
		} catch (ModelException me) {
			return me.getMessage();
		}
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		try {
			this.getTheObject().valueForPathChanged(path, newValue);
		} catch (ModelException e) {
			return;
		}		
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getRowCount() {
		try {
			return this.getTheObject().getRowCount();
		} catch (ModelException e) {
			return 0;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			return this.getTheObject().getValueAt(rowIndex, columnIndex);
		} catch (ModelException e) {
			return e.getMessage();
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		try {
			return this.getTheObject().isCellEditable(rowIndex, columnIndex);
		} catch (ModelException e) {
			return false;
		}
	}

	public boolean isRowEditable(int index) {
		try {
			return this.getTheObject().isRowEditable(index);
		} catch (ModelException e) {
			return false;
		}
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		try {
			this.getTheObject().setValueAt(aValue, rowIndex, columnIndex);
		} catch (ModelException e) {
			return;
		}
	}

	public void addTableModelListener(TableModelListener l) {
		try {
			this.getTheObject().addTableModelListener(l);
		} catch (ModelException e) {
			throw new Error(e.getMessage());
		}
	}

	public void removeTableModelListener(TableModelListener l) {
		try {
			this.getTheObject().removeTableModelListener(l);
		} catch (ModelException e) {
			throw new Error(e.getMessage());
		}
	}
	public String createProxiInformation() {
		return RPCConstantsAndServices.createFromClientProxiRepresentation(this.getClassId(), this.getId(), this.getRemoteDepth());
	}

}
