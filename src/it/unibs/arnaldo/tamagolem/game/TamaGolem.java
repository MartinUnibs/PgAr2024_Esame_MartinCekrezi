package it.unibs.arnaldo.tamagolem.game;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO: DOC
public class TamaGolem {

    private static final int HP = 100;

    private int hp;
    private Deque<Element> stones;

    public TamaGolem() {
        hp = HP;
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
