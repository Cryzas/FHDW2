package view.objects;

import view.ModelException;

public interface AbstractViewRoot {

  public long getId();
  public long getClassId();
  public ViewObject getTheObject() throws ModelException;
  public boolean isLeaf() throws ModelException;
  public boolean isTheSameAs(Object argument);
  

}