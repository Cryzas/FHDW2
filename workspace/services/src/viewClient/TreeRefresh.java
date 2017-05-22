package viewClient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;

import javax.swing.tree.TreeModel;

import view.ModelException;

import view.objects.ViewObjectInTree;
import view.objects.ViewProxi;
import view.objects.ViewRoot;


public class TreeRefresh extends TreeView<ViewObjectInTree>{
	
	private TreeItem<ViewObjectInTree> rootFX = null;
	private ExceptionAndEventHandler exceptionHandler;

	public TreeRefresh( ExceptionAndEventHandler exceptionHandler){
		super();
		this.exceptionHandler = exceptionHandler;
		this.setShowRoot( false );
		this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//		this.setCellRenderer(new IconRenderer());
//		this.setRowHeight(20);
	}
 
	public void setModel( javax.swing.tree.TreeModel model ){
		this.root = model;
		if( model instanceof ViewProxi){
			ViewProxi proxi = (ViewProxi) model;
			proxi.expand();
		}
		this.setTreeModel(model);
	}

	private void setTreeModel( TreeModel model ) {	
		if( model != null ){			
			this.rootFX = this.createNode( (ViewObjectInTree) model.getRoot());
			this.rootFX.setExpanded( true );
			this.setRoot( this.rootFX );
		}
	}

	private TreeModel root = null;
	public TreeModel getModel(){
		return root;
	}

	private TreeItem<ViewObjectInTree> createNode( final ViewObjectInTree obj ){
		return new TreeItem<ViewObjectInTree>(obj){
			private boolean isLeaf = true;
			private boolean isFirstTimeLeaf = true;
			private boolean isFirstTimeChildren = true;

			@Override
			public boolean isLeaf() {				
				if( this.isFirstTimeLeaf ){
					this.isFirstTimeLeaf = false;
					try {
						this.isLeaf = obj.isLeaf();
					} catch (ModelException me) {
						exceptionHandler.handleException( me);
					}
				}
				return isLeaf;				
			}
			@Override
			public ObservableList<TreeItem<ViewObjectInTree>> getChildren(){
				if( this.isFirstTimeChildren ){
					this.isFirstTimeChildren = false;
					super.getChildren().setAll( this.buildChildren( this ) );
				}		
				return super.getChildren();		
			}
			private ObservableList<TreeItem<ViewObjectInTree>> buildChildren(TreeItem<ViewObjectInTree> item) {
				ViewObjectInTree obj = item.getValue();
				if( obj == null) return FXCollections.emptyObservableList();
				ObservableList<TreeItem<ViewObjectInTree>> children = FXCollections.observableArrayList();
				try {
					if( this.isLeaf() ) return FXCollections.emptyObservableList();
					int childCount = ( obj instanceof ListRoot) ? ((ListRoot) obj).getChildCount( obj)
																: obj.getChildCount();						
					for (int i = 0; i < childCount; i++) {
						ViewObjectInTree current = obj.getChild(i);
						TreeItem<ViewObjectInTree> child = createNode( current );
						child.setGraphic(new ImageView( current.getImage()));
						children.add( child );			   
					}
				} catch (ModelException me) {
					exceptionHandler.handleException( me);
				};
				return children;
			}
		};
	}

	private TreeItem<ViewObjectInTree> oldRootFX = null;
	public void refreshTree() throws ModelException {
		ViewProxi model = (ViewProxi) this.getModel();
		List<ViewObjectInTree> lastSelectedPath = null;
		Vector<List<ViewObjectInTree>> selectedPaths = new Vector<List<ViewObjectInTree>>();
		Set<ViewRoot> visibleContext = new HashSet<ViewRoot>();
		if( this.getModel() != null ){			
			this.oldRootFX = this.rootFX;
			this.addExpandedToVisibleContext( this.oldRootFX, visibleContext);
			if( this.getSelectionModel().getSelectedItem() != null ){
				lastSelectedPath = this.extractSelectedPath2( this.getSelectionModel().getSelectedItem() );
				visibleContext.add( this.getSelectionModel().getSelectedItem().getValue().getWrappedObject());
			}
			for (int i = 0; i < this.getSelectionModel().getSelectedItems().size(); i++) {
				selectedPaths.add( this.extractSelectedPath2( this.getSelectionModel().getSelectedItems().get(i)));
				visibleContext.add( this.getSelectionModel().getSelectedItems().get(i).getValue().getWrappedObject() );
			}
		}
		model.getRemote( new Vector<ViewRoot>(visibleContext), true );
		this.setModel( model );
		if( this.getModel() != null ){
			ViewObjectInTree server = this.oldRootFX.getValue();
			if( this.rootFX.getValue().getWrappedObject().equals( server.getWrappedObject())){
				this.setExpandedPaths( this.rootFX, this.oldRootFX);
				TreeItem<ViewObjectInTree> item;
				this.getSelectionModel().clearSelection();
				for( List<ViewObjectInTree> current : selectedPaths) {
					item = findSelectedItem2( current, this.rootFX );
					if( item != null ){
						this.getSelectionModel().select( item );
					} 					
				}
				if( lastSelectedPath != null ){
					item = findSelectedItem2( lastSelectedPath, this.rootFX);
					if( item != null ){
						this.getSelectionModel().select( item );
					}
				}				
			}
		}
	}
	
	private void addExpandedToVisibleContext( TreeItem<ViewObjectInTree> root, Set<ViewRoot> visibleContext) {
		for( TreeItem<ViewObjectInTree> current : root.getChildren()) {
			if( current.isExpanded() ){
				visibleContext.add( current.getValue().getWrappedObject() );
				this.addExpandedToVisibleContext( current, visibleContext );
			}
		}
	}

	private void setExpandedPaths( TreeItem<ViewObjectInTree> newRoot, TreeItem<ViewObjectInTree> oldRoot) {
		for( TreeItem<ViewObjectInTree> childOld : oldRoot.getChildren()) {
			if( childOld.isExpanded() 
			&&	this.wasExpandedEverywhere( oldRoot, childOld.getValue() ) ){
				for( TreeItem<ViewObjectInTree> childNew : newRoot.getChildren()) {
					if( childNew.getValue().equals( childOld.getValue()) ){						
						childNew.setExpanded( true );
						this.setExpandedPaths( childNew, childOld );
						break;
					}
				}				
			}
		}				
	}
		
	List<TreeItem<ViewObjectInTree>> getMatchingItems ( String searchString ){
		List<TreeItem<ViewObjectInTree>> result = new ArrayList<TreeItem<ViewObjectInTree>>();
		if ( this.isShowRoot() ){
			result = this.getMatchingItems( this.rootFX, searchString);
//			System.out.println("root: " + result.size() + "für:  " +rootFX.getValue().getWrappedObject().toString());
		} else {
			for (TreeItem<ViewObjectInTree> child : rootFX.getChildren()) {
				result.addAll( this.getMatchingItems( child, searchString) );				
//				System.out.println( result.size() +  "  für:  " +child.getValue().getWrappedObject().toString());
			}
		}
		return result;		
	}
	
	private List<TreeItem<ViewObjectInTree>> getMatchingItems( TreeItem<ViewObjectInTree> item, String searchString) {
		List<TreeItem<ViewObjectInTree>> result = new ArrayList<TreeItem<ViewObjectInTree>>();
		if( item.getValue().getWrappedObject().toString().contains( searchString) ){
			result.add( item );
		}
		if( item.isExpanded()){
			for (TreeItem<ViewObjectInTree> child : item.getChildren()) {
				result.addAll( this.getMatchingItems(child, searchString));
			}
		}
		return result;
	}

	/**
	 * @return true, if multiple occurrences on same level and always expanded
	 */
	private boolean wasExpandedEverywhere( TreeItem<ViewObjectInTree> item, ViewObjectInTree searched) {
		for( TreeItem<ViewObjectInTree> current : item.getChildren()) {
			if( current.getValue().equals( searched )){
				if( ! current.isExpanded() ) return false;
			}
		} 
		return true;
	}

	private TreeItem<ViewObjectInTree> findSelectedItem2( List<ViewObjectInTree> oldPath, TreeItem<ViewObjectInTree> root) {
		if( root == null ) return null;
		
		ViewObjectInTree searched = oldPath.get(0);
		if( ! searched.equals( root.getValue()) ) return null;
		TreeItem<ViewObjectInTree> node = root;
		boolean found;
		for (int i = 1; i < oldPath.size(); i++) {
			searched = oldPath.get(i);
			found = false;
			for (TreeItem<ViewObjectInTree> child : node.getChildren()) {
				if( searched.equals(child.getValue())) {
					node = child;
					found = true;
					break;
				}
			}
			if( found == false ) return null;
		}
		return node;
	}
	private List<ViewObjectInTree> extractSelectedPath2( TreeItem<ViewObjectInTree> item) {
		List<ViewObjectInTree> path = new ArrayList<ViewObjectInTree>();
		while( item != null){
			path.add( 0, item.getValue() );
			item = item.getParent();
		}
		return path;
	}
	
	/**
	 * @return the currently selected object; returns null if nothing is selected
	 */
	public ViewRoot getSelectedObject(){
		ViewObjectInTree selectedWapper = this.getSelectedWrapper();
		if (selectedWapper != null) return selectedWapper.getWrappedObject();
		return null;
	}
	public ViewObjectInTree getSelectedWrapper(){
		return this.getSelectionModel().getSelectedItem().getValue();
	}
}
