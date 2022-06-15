package stargame;

import java.security.KeyPair;
import java.util.*;
import java.util.stream.Collectors;

public  class FighterGroup {
    static double ValuableCount = 0.01;
    List<FighterBase> fighters = new ArrayList<>();

    public void addFighter(FighterBase fighter,double count){
        fighter.count = count;
        fighters.add(fighter);
    }

    public static void DoFight(FighterGroup group1, FighterGroup group2) {
        //temp保存完整的攻击方信息
        final List<FighterBase> temp1 = group1.fighters.stream().map(FighterBase::clone).collect(Collectors.toList());
        final List<FighterBase> temp2 = group2.fighters.stream().map(FighterBase::clone).collect(Collectors.toList());
        doFight(temp1,group2.fighters);
        doFight(temp2,group1.fighters);
    }

    private static void doFight(List<FighterBase> attacker, List<FighterBase> target) {
        HashMap<FighterBase, Double> fightWeightPercent = new HashMap<>();
        double totalWeight = 0;
        for (FighterBase fighterBase : target) {
            totalWeight += fighterBase.fightWeight * fighterBase.count;
        }
        for (FighterBase fighterBase : target) {
            fightWeightPercent.put(fighterBase, fighterBase.fightWeight * fighterBase.count / totalWeight);
        }

        final List<FighterBase> sortedAttacker = attacker.stream()
                .sorted(Comparator.comparingDouble(c -> c.fightWeight))
                .collect(Collectors.toList());
        final List<FighterBase> sortedTarget = target.stream()
                .sorted(Comparator.comparingDouble(c -> c.fightWeight))
                .collect(Collectors.toList());


        for (FighterBase currentAttacker : sortedAttacker) {
            double attackerTotalCount = currentAttacker.count;

            do {
                double remainAttacker = 0;
                ListIterator<FighterBase> targetListIterator = sortedTarget.listIterator();
                while (targetListIterator.hasNext()) {
                    FighterBase currentTarget = targetListIterator.next();
                    //使用多少来攻击这个目标
                    double attackerCount = attackerTotalCount * fightWeightPercent.get(currentTarget);
//                    System.out.println(attackerCount+"个"+currentAttacker.name);
//                    System.out.println("攻击");
//                    System.out.println(currentTarget.count+"个"+currentTarget);
                    //计算剩余的攻击者数量 用于下一轮
                    remainAttacker +=
                            //进行战斗计算
                            currentAttacker.attack(attackerCount, currentTarget);
//                    System.out.println("存活"+currentTarget.count+"个"+currentTarget.name);
//                    System.out.println("剩余攻击者 "+remainAttacker+"个"+currentAttacker.name);
//                    System.out.println();
                    //目标被摧毁了
                    if (currentTarget.count <= ValuableCount) {
                        targetListIterator.remove();
                    }
                }
                //如果第一轮中，有某次攻击消灭了一种敌人的全部数量，则进行新的一轮攻击 新一轮中的可用数量
                attackerTotalCount = remainAttacker;
            } while (//还有可用的攻击者
                    attackerTotalCount >= ValuableCount
                            &&
                            //还有剩余的敌人
                            !sortedTarget.isEmpty()
            );
            if (sortedTarget.isEmpty()) {
                break;
            }
        }


    }

    @Override
    public String toString() {
        return "FighterGroup{" +
                "fighters=" + fighters +
                '}';
    }
}
