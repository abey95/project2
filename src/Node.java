/**
 * The linked stack provides the stack used for
 * the discs.
 * @author abey95
 * @version 2016.10.16
 */
public class Node
{
    private int x;
    private int y;
    private int z;
    private int name;
    
    public Node(int x, int y, int z, int name) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    
    public int getName()
    {
        return name;
    }

    public void setName(int name)
    {
        this.name = name;
    }

    public int getX()
    {
        return x;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public int getY()
    {
        return y;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getZ()
    {
        return z;
    }
    public void setZ(int z)
    {
        this.z = z;
    }
    public double getDistance(Node node2)
    {
        return (Double) Math.sqrt(Math.pow((node2.getZ()-this.getZ()), 2) + Math.pow((node2.getY()-this.getY()), 2) + Math.pow((node2.getX()-this.getX()), 2));
    }    

}
