package MyTools.我的数据结构.twst;

public abstract class Father {
    String fatherName;

    {
        System.out.println(this.getClass().getName());
    }

    public Father() {

    }

    @Override
    public String toString() {
        System.out.println(this.getClass().getName());

        return super.toString();
    }

}
