package it.unibs.arnaldo.tamagolem.game;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * This class represents a single TamaGolem. its
 * stones are managed using a queue. The size of
 * this queue is not specified, since it's implemented
 * in the Player class.
 * */
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
