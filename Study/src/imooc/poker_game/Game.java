package imooc.poker_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Description:扑克游戏 来自imooc
 * Version:1.0
 * Created by leal
 * On 17-2-28:下午11:42.
 */
public class Game
{
    public List<Poker> pokerList;
    private Scanner console;
    public Map<Integer, Player> playerMap;
    /**
     * 不要随便定义静态变量
     */
    public int a;//定义全局变量
    public int b;

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Game game = new Game();
        game.addCard();
        game.addPlayer();
        game.mixtureCard();
        game.beginGame();
    }

    /**
     * 初始化变量
     */
    public Game()
    {
        this.pokerList = new ArrayList<>();
        this.playerMap = new HashMap<>();
        /**
         * 编码转换
         */
        console = new Scanner(System.in,"UTF-8");
    }

    /**
     * 创建扑克牌
     */
    protected void addCard()
    {
        String[] design = {"♦", "♣", "♥", "♠"};
        String[] num = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Poker ca = new Poker(design[i], num[j]);
                pokerList.add(ca);
            }
        }
        System.out.println("----------创建扑克牌-------------");
        System.out.println("----------扑克牌创建成功!----------");
        for (Poker poker : pokerList) {
            System.out.print("[" + poker.getDesign() + poker.getNum() + "]");
        }
        System.out.println();
    }

    /**
     * 洗牌
     */
    public void mixtureCard()
    {
        System.out.println("----------开始洗牌-------------");
        Collections.shuffle(pokerList);// 集合中的乱序方法
        for (Poker poker : pokerList) {
            System.out.print("[" + poker.getDesign() + poker.getNum() + "]");
        }
        System.out.println("\n----------洗牌结束!------------");
    }

    public void addPlayer()
    {
        System.out.println("----------创建玩家-------------");
        for (int i = 0; i < 2; ) {
            System.out.println("请输入第" + (i + 1) + "位玩家的ID和姓名：");
            System.out.println("请输入玩家ID");
            int id;//初始化id
            try {
                id = scanInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            Player p = playerMap.get(id);
            if (p == null) {
                System.out.println("请输入玩家姓名");
                String name = console.next();
                // playerMap2.put(id, new Player(id,name));//用于鉴定两次输入的id是否相同，因现在不能够保存两次输入的id值，
                // playerMap.put(i+1, new Player(id,name));//用于之后的输出，key为1，2
                playerMap.put(id, new Player(id, name));
                //存储两次输入的ID，以便后续的Map中用key查找value
                switch (i) {
                    case 0:
                        a = id;
                        break;
                    case 1:
                        b = id;
                        break;
                    default:
                        System.out.println("未知错误");
                }
                i++;//这种处理方法可以的
                System.out.println("添加成功！");
            } else {
                System.out.println("该ID已被占用！请再次添加");
                continue;//跳出当前，直接回到循环开始
            }
        }
    }

    /**
     * 判断输入玩家编号异常值
     *
     * @return
     * @throws Exception
     */
    public int scanInt() throws Exception
    {
        try {
            int in = console.nextInt();
            return in;
        } catch (Exception e) {
            console = new Scanner(System.in,"UTF-8");
            throw new Exception("输入异常，请输入整数类型的ID");
        }
    }

    /**
     * 开始游戏
     */
    public void beginGame()
    {
        System.out.println("欢迎玩家" + playerMap.get(a).getName() + "," + playerMap.get(b).getName());
        System.out.println("----------开始发牌-------------");

        System.out.println(playerMap.get(a).getName() + "得到第一张牌");
        playerMap.get(a).getPokerList().add(pokerList.get(0));
        System.out.println(playerMap.get(b).getName() + "得到第一张牌");
        playerMap.get(b).getPokerList().add(pokerList.get(1));
        System.out.println(playerMap.get(a).getName() + "得到第二张牌");
        playerMap.get(a).getPokerList().add(pokerList.get(2));
        System.out.println(playerMap.get(b).getName() + "得到第二张牌");
        playerMap.get(b).getPokerList().add(pokerList.get(3));

        System.out.println("----------发牌结束！------------");
        System.out.println("----------开始游戏-------------");
        System.out.println("玩家各自手牌为");
        Poker a1 = playerMap.get(a).getPokerList().get(0);
        Poker a2 = playerMap.get(a).getPokerList().get(1);
        System.out.println(playerMap.get(a).getName() + ":" + a1.toString() + ":" + a2.toString());
        Poker b1 = playerMap.get(b).getPokerList().get(0);
        Poker b2 = playerMap.get(b).getPokerList().get(1);
        System.out.println(playerMap.get(b).getName() + ":" + b1.toString() + ":" + b2.toString());
        System.out.println("---------------------------");
        PokerComparator p = new PokerComparator();
        Poker aMax = p.maxPoker(a1, a2, p.compare(a1, a2));
        Poker bMax = p.maxPoker(b1, b2, p.compare(b1, b2));
        System.out.println(playerMap.get(a).getName() + "的最大的手牌为" + aMax);
        System.out.println(playerMap.get(b).getName() + "的最大的手牌为" + bMax);

        String win_player = p.compare(aMax, bMax) > 0 ? playerMap.get(a).getName() : playerMap.get(b).getName();
        System.out.println("----------" + win_player + "获得胜利！----------");

    }

}
