package ie.tudublin;

public class Task
{
    private String Task;
    private int Start;
    private int End;

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
}