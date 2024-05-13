package it.unibs.arnaldo.tamagolem.game;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO: DOC
public class TamaGolem {

    public static final int MAX_HP = 100;

    private int hp;
    private Deque<Element> stones;

    public TamaGolem() {
        hp = MAX_HP;
        stones = new ArrayDeque<>();
    }

    public void hit(int damage) {
        hp -= damage;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void addStone(Element stone) {
        stones.add(stone);
    }

    public Element throwStone() {
        Element thrown = stones.remove();
        stones.add(thrown);
        return thrown;
    }
}
