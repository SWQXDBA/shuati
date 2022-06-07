package stargame;

public abstract class FighterBase implements Cloneable{
    double count;
    /**
     * 船体值
     */
    double hull;

    double shield;
    double armor;
    /**
     * 装甲厚度
     */
    double armorThickness;
    double attackPower;
    /**
     * 穿甲深度
     */
    double armorPiercing;

    /**
     * 战斗权重
     */
    int fightWeight;

    /**
     *
     * @param usedCount 此次攻击使用的个数，必须小于this.count;
     * @param other 被攻击的对象 other.count会在计算中被修改
     * @return 剩余的count
     */
    public double attack(double usedCount, FighterBase other) {
        double totalDamage = attackPower * usedCount;
        //计算护盾
        if (other.shield >= attackPower) {
            return 0;
        }
        totalDamage -= other.count * other.shield;
        //计算装甲
        totalDamage *= armorCoefficientCompute(armorPiercing,other.armorThickness);

        double totalHull = other.hull*other.count;
        //击败了所有的目标
        if(totalHull<=totalDamage){
            other.count = 0;
            return usedCount - (totalDamage-totalHull)/attackPower;
        }
        //未能击败了所有的目标
        double remainTotalHull = totalHull-totalDamage;
        other.count = remainTotalHull/other.hull;
        return 0;

    }

    /**
     * 计算装甲可以抵挡多少伤害，返回一个剩余的伤害系数
     * @param armorPiercing 攻击者的穿甲深度
     * @param armorThickness 被攻击者的装甲厚度
     * @return 结算后的伤害系数
     */
    private static double armorCoefficientCompute(double armorPiercing, double armorThickness) {
        if (armorPiercing >= armorThickness) {
            return 1;
        } else {
            return (armorThickness - armorPiercing) / 2;
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
