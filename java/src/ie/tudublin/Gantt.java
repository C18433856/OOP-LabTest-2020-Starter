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
		int i = 1;
		Table task_table = loadTable("tasks.csv", "header");
		rectMode(CENTER);
		noStroke();

		for(TableRow row:task_table.rows())
		{	
			int curr_start = row.getInt("Start");
			int curr_end = row.getInt("End");
			float mark = map(i, 1, Tasks.size(), (3 * reg_border), height - 5 * reg_border);
			float mark2 = map(curr_start,1, 30, left_border, width - reg_border);
			float mark3 = map(curr_end,1, 30, left_border, width - reg_border);

			fill(i * 20, 200, 200);
			rect((mark2 + mark3) / 2, mark, mark3 - mark2, 30, 6);
			i++;

		}
	}

	void displayGrid()
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
		
		Table task_table = loadTable("tasks.csv", "header");
		int i = 1;

		for(TableRow row: task_table.rows())
		{
			float mark = map(i, 1, Tasks.size(), (3 * reg_border), height - 5 * reg_border);
			text(row.getString("Task"), reg_border, mark);
			i++;
		}
	}
	
	public void mousePressed()
	{
		//println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		//println("Mouse dragged");
	}

	
	public void setup() 
	{
		background(0);
		loadTasks();
		printTasks();
		textAlign(BASELINE, CENTER);
		displayGrid();
		colorMode(HSB, 200);
		displayTasks();
		
	}
	
	public void draw()
	{		

	}
}
