package ie.tudublin;

import processing.data.TableRow;

public class Task
{
    private String Task;
    private int Start;
    private int End;

    public Task(String Task, int Start, int End)
    {
        this.Task = Task;
        this.Start = Start;
        this.End = End;
    }

    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    public String getTask()
    {
        return Task;
    }

    public int getStart()
    {
        return Start;
    }

    public int getEnd()
    {
        return End;
    }

    public void setTask(String Task)
    {
        this.Task = Task;
    }

    public void setStart(int Start)
    {
        this.Start = Start;
    }

    public void setTask(int End)
    {
        this.End = End;
    }

    public String toString() {
        return "Details: Task= " + Task + " , Start= " + Start + " , End= " + End + "\n";
    }
}