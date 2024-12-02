package jp.ac.uryukyu.ie.ichi;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name キャラクター名
     * @param hitPoint キャラクターのHP
     * @param attack キャラクターの攻撃力
     */
    public LivingThing(String name, int hitPoint, int attack){
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    /**
     * LivingThing へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(isDead() == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    // setter
    /**
     * フィールド変数hitPointのsetterメソッド。
     * @param hitPoint キャラクターのHP
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * フィールド変数deadのsetterメソッド。
     * @param dead キャラクターの生死状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

    // getter
    /**
     * フィールド変数nameのgetterメソッド。
     * @return キャラクターの名前
     */
    public String getName(){
        return name;
    }

    /**
     * フィールド変数hitPointのgetterメソッド。
     * @return キャラクターのHP
     */
    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * フィールド変数attackのgetterメソッド。
     * @return キャラクターの攻撃力
     */
    public int getAttack(){
        return attack;
    }

    /**
     * フィールド変数deadのgetterメソッド。
     * @return キャラクターの生死状態
     */
    public boolean isDead(){
        return dead;
    }


    /**
     * toStringをオーバーライドしたメソッド。
     * オブジェクトの実行時クラスと、フィールドに格納されている値を表示する。
     * @return オブジェクトの実行時クラスと、フィールドに格納されている値
     */
    @Override
    public String toString(){
        return this.getClass() + ", name=" + this.getName() +  ", hitPoint=" + this.getHitPoint() + ", attack=" + this.getAttack() + ", dead=" + this.isDead();
    }
}
