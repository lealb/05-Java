package imooc.poker_game;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Description:
 * Version:1.0
 * Created by leal
 * On 17-2-28:下午11:36.
 */
public class PokerComparator implements Comparator<Poker>,Serializable
{
    /**
     * 解释：实现了Comparator接口却没有实现Serializable接口，因为像TreeMap这种可序列化数据结构
     * （它实现了Serializable接口）只有当比较器继承了Serializable接口时，它才能被序列化。
     * 解决：实现Serializable接口并定义serialVersionUID字段
     */
    private static final long serialVersionUID = 1L;
    @Override
    public int compare(Poker o1, Poker o2)
    { // TODO Auto-generated method stub
        String a = "♦♣♥♠";//由小到大创建字符串花色和大小
        String b = "2345678910JQKA";
        int a1 = a.indexOf(o1.getDesign());//分别查找，花色和大小在顺序字符串中的位置，位置大的即大
        int b1 = b.indexOf(o1.getNum());
        int a2 = a.indexOf(o2.getDesign());
        int b2 = b.indexOf(o2.getNum());
        if (b1 > b2) {
            //通过索引位置判断俩牌大小
            return 1;
        } else if (b1 == b2) {
            if (a1 > a2) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    /**
     * 根据compare方法，判断出手牌的大小，返回大的牌
     *
     * @param o1
     * @param o2
     * @param c
     * @return
     */
    public Poker maxPoker(Poker o1, Poker o2, int c)
    {
        if (c > 0) {
            return o1;
        } else {
            return o2;
        }
    }
}


