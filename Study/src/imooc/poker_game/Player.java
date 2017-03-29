package imooc.poker_game;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-28:下午11:34.
 */
public class Player
{
    private Integer id;
    private String name;
    private List<Poker> pokerList;

    public String getName()
    {
        return name;
    }

    public List<Poker> getPokerList()
    {
        return pokerList;
    }

    public Player(int id, String name)
    {
        this.pokerList = new ArrayList<>();
        this.id = id;
        this.name = name;
    }

}
