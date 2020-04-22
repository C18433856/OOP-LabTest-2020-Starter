package ie.tudublin;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

import processing.core.PApplet;

public class Gantt extends PApplet
{	
	ArrayList<Task> Tasks = new ArrayList<Task>();

	float reg_border = 40;
	float left_border = 140;
	
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table task_table = loadTable("tasks.csv", "header");

		for(TableRow row:task_table.rows())
		{
		  Task new_task = new Task(row);    
		  Tasks.add(new_task);
		}
	}

	public void printTasks()
	{
		for(Task task:Tasks)
		{
			System.out.print(task.toString());
		}
	}

	public void displayTasks()
	{

	}

	void DisplayGrid()
	{
		colorMode(RGB);
		stroke(255);

		for(int x = 1 ; x <=30; x ++)
		{
			if (x % 2 != 0)
			{
				strokeWeight(1);
				stroke(255);
			}
			else
			{
				strokeWeight((float) 0.5);
				stroke(200);
				if (x == 30)
				{
					strokeWeight(1);
					stroke(255);
				}
			}
			float mark = map(x, 1, 30, left_border, width - reg_border);
			line(mark, reg_border, mark, height - reg_border);
			text(x, (mark-5), 30);			// The x coordinate is shifted a bit to the left
		}
		
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
		background(0);
		loadTasks();
		printTasks();
		drawGrid();
		colorMode(HSB);
	}
	
	public void draw()
	{		

	}
}
