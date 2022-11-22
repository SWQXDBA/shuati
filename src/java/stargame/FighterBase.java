package stargame;

public abstract class FighterBase implements Cloneable {

    protected String name;
    double count;
    /**
     * 船体值
     */
    protected double hull;

    protected double shield;

    /**
     * 装甲厚度
     */
    protected double armorThickness;
    protected double attackPower;
    /**
     * 穿甲深度
     */
    protected double armorPiercing;

    /**
     * 战斗权重
     */
    protected int fightWeight;

    @Override
    public String toString() {
        return name+"{" +
                "count=" + count +
                '}';
    }

    /**
     * @param usedCount 此次攻击使用的个数，必须小于this.count;
     * @param other     被攻击的对象 other.count会在计算中被修改
     * @return 剩余的count
     */
    public double attack(double usedCount, FighterBase other) {

        //计算护盾
        if (other.shield >= attackPower) {
            return 0;
        }
        double totalDamage = (attackPower-other.shield) * usedCount;
        //计算装甲
        totalDamage *= armorCoefficientCompute(armorPiercing, other.armorThickness);

//        System.out.println("实际攻击力"+totalDamage);
        double totalHull = other.hull * other.count;
        //击败了所有的目标
        if (totalHull <= totalDamage) {
            other.count = 0;
            return usedCount * (totalDamage - totalHull) / totalDamage;
        }
        //未能击败了所有的目标
        double remainTotalHull = totalHull - totalDamage;
        other.count = remainTotalHull / other.hull;
        return 0;

    }

    /**
     * 计算装甲可以抵挡多少伤害，返回一个剩余的伤害系数
     *
     * @param armorPiercing  攻击者的穿甲深度
     * @param armorThickness 被攻击者的装甲厚度
     * @return 结算后的伤害系数
     */
    private static double armorCoefficientCompute(double armorPiercing, double armorThickness) {
        if (armorPiercing >= armorThickness) {
            return 1;
        } else {
            return (armorThickness - armorPiercing) /armorThickness/ 2;
        }
    }

    @Override
    public FighterBase clone() {
        try {
            FighterBase clone = (FighterBase) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
