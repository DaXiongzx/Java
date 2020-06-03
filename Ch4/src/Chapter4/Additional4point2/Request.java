package Chapter4.Additional4point2;

public class Request
{

    String Name, Ct_No;

    public void setName(String name)
    {
        this.Name = name;
    }

    public void setNo(String cno)
    {
        this.Ct_No = cno;
    }

    public String getName()
    {
        return Name;
    }

    public String getNo()
    {
        return Ct_No;
    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(Name);
        return buffer.toString();
    }
}
