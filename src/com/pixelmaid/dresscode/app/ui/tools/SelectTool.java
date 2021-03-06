package com.pixelmaid.dresscode.app.ui.tools;

import java.util.ArrayList;

import com.pixelmaid.dresscode.drawing.datatype.Point;
import com.pixelmaid.dresscode.drawing.primitive2d.Drawable;
import com.pixelmaid.dresscode.events.CustomEvent;

public class SelectTool extends Tool  {
	private Drawable selectedDrawable;
	private boolean selected;
	private boolean moved;
	private ArrayList<Drawable> tempDrawables;
	private double selectDist = 5;
	
	public SelectTool(){
	
	}
	
	public void init(){
	
	}
	
	public void reset(){
		
		for(int i=0;i<tempDrawables.size();i++){
			tempDrawables.get(i).setSelected(false);
			System.out.println("setting "+i+" to false");
		}
		
		selectedDrawable = null;
		selected = false;
		moved = false;
	}
	
	@Override 
	public void setActive(boolean a){
		this.reset();
		
		active = a;
	}
	
	public void setDrawables(ArrayList<Drawable>tD){
		tempDrawables = tD;
		
	}
	
	@Override
	public void mouseReleased(double mouseX, double mouseY) {
		if(moved){
			this.fireToolEvent(CustomEvent.DRAWABLE_MOVED);
		}
		
	}
	
	@Override
	public void mousePressed(double mouseX, double mouseY) {
		reset();
		for(int i=tempDrawables.size()-1;i>=0;i--){
			Point origin = tempDrawables.get(i).getOrigin();
			
			if((Math.abs(mouseX-origin.getX())<selectDist)&&(Math.abs(mouseY-origin.getY())<selectDist)){
				selectedDrawable = tempDrawables.get(i);
				selected=true;
				selectedDrawable.setSelected(true);
				System.out.println("selected object at"+i);
				break;
		
			}
		}
		this.fireToolEvent(CustomEvent.REDRAW_REQUEST);

		
		
	}
	
	@Override
	public void mouseDragged(double mouseX, double mouseY) {

		if(selected){
			selectedDrawable.moveTo(mouseX,mouseY);
		
			moved=true;
			System.out.println("select drag");
			System.out.println(selectedDrawable.getOrigin().getX()+","+selectedDrawable.getOrigin().getY());
			this.fireToolEvent(CustomEvent.REDRAW_REQUEST);
		}
	
	}
	
	public boolean shapeSelected(){
		return selected;
	}
	
	public boolean shapeMoved(){
		return moved;
	}

	public Drawable getSelected(){
		return this.selectedDrawable;
	}
	
	
}
