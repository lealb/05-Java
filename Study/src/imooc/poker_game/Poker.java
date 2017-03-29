package imooc.poker_game;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-28:下午11:28.
 */
public class Poker
{
    private String design;
    private String num;

    public String getDesign()
    {
        return design;
    }

    public String getNum()
    {
        return num;
    }

    @Override
    public String toString()
    {
        return design + num;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Poker)) return false;

        Poker poker = (Poker) o;

        if (design != null ? !design.equals(poker.design) : poker.design != null) return false;
        return num != null ? num.equals(poker.num) : poker.num == null;
    }

    @Override
    public int hashCode()
    {
        int result = design != null ? design.hashCode() : 0;
        result = 31 * result + (num != null ? num.hashCode() : 0);
        return result;
    }


    public Poker(String design, String num)
    {
        this.design = design;
        this.num = num;
    }

}
