package ie.tudublin;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

import processing.core.PApplet;

public class Gantt extends PApplet
{	
	ArrayList<Task> Tasks = new ArrayList<Task>();
	
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table task_table = loadTable("HabHYG15ly.csv", "header");

		for(TableRow row:task_table.rows())
		{
		  Task new_task = new Task(row);    
		  Tasks.add(new_task);
		}
	}

	public void printTasks()
	{
		
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	public void setup() 
	{

	}
	
	public void draw()
	{		

	}
}
