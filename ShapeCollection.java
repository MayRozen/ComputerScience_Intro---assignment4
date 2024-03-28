/*
 * ID: 212051007
 */
package Exe.Ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements ShapeCollectionable{
	private ArrayList<GUI_Shapeable> _shapes;
	
	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shapeable>();
	}
	@Override
	public GUI_Shapeable get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shapeable removeElementAt(int i) {
		GUI_Shapeable shape = _shapes.get(i); //Save the value in index i;
		_shapes.remove(i); //Remove this value.
		return shape;
	}

	@Override
	public void addAt(GUI_Shapeable s, int i) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(i, s);
		}
	}
	@Override
	public void add(GUI_Shapeable s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}
	@Override
	public ShapeCollectionable copy() {
		ShapeCollection SH = new ShapeCollection();
		if(_shapes==null) { //If _shapes is null, we don't have what to copy.
			return null;
		}
	
		for(GUI_Shapeable s: _shapes) { //Copy all the shapes to SH from shapes.
			SH.add(s.copy());
		}
		return SH;
	}

	@Override
	public void sort(Comparator<GUI_Shapeable> comp) {
		_shapes.sort(comp);
	}

	@Override
	public void removeAll() {
		_shapes.clear();
	}

	@Override
	public void save(String file) {
		try {
			FileWriter F = new FileWriter(file); //Create a new file.
			PrintWriter pw = new PrintWriter(F);
			
			F.write("Text file named: " + file + "\n");
			for(GUI_Shapeable s : _shapes) {
				pw.println(s.toString());
			}
			F.write("End of file");
			
			F.close(); //Close the file.
		}
		catch(Exception e){
			System.out.println("Error reading file/s"+e);
			e.printStackTrace();
		}
	}

	@Override
	public void load(String file) {
		try {
			File f = new File(file); //Create a new file.
			Scanner myReader = new Scanner(f); 
			this._shapes.clear();
			while(myReader.hasNext()) { //If it has next value.
				this._shapes.add(new GUIShape(myReader.nextLine())); //Add the GUIShape you create from myReader to _shapes.
			}
			myReader.close();
		}
		catch(FileNotFoundException e){ //If you do not find the file.
			e.printStackTrace();	
		}
	}
	@Override
	public Rect2D getBoundingBox() {
		Rect2D ans = null;
		double xmin = 10, ymin = 10;
		double xmax = 0, ymax = 0;
		for(int i=0; i<this.size(); i++) {
			GUI_Shapeable gs = this.get(i);
			GeoShapeable g = gs.getShape();
			for(int j=0; j<g.getPoints().length; j++) {
				if(g.getPoints()[j].x()<xmin) {xmin = g.getPoints()[j].x();}
				if(g.getPoints()[j].x()>xmax) {xmax = g.getPoints()[j].x();}
				if(g.getPoints()[j].y()<ymin) {ymin = g.getPoints()[j].y();}
				if(g.getPoints()[j].y()>ymax) {ymax = g.getPoints()[j].y();}
				if(g instanceof Circle2D) {
					Point2D cen = g.getPoints()[0];
					double rad = ((Circle2D)g).getRadius();
					if(cen.x()-rad<xmin) {xmin = cen.x()-rad;}
					if(cen.x()+rad>xmax) {xmax = cen.x()+rad;}
					if(cen.y()-rad<ymin) {ymin = cen.y()-rad;}
					if(cen.y()+rad>ymax) {ymax = cen.y()+rad;}
				}
			}
			Point2D p1 = new Point2D(xmin,ymax);
			Point2D p2 = new Point2D(xmax,ymin);
			ans = new Rect2D(p1,p2);
		}
		return ans;
	}
	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}
	

}
