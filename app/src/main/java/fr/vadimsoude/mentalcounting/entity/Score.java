package fr.vadimsoude.mentalcounting.entity;

public class Score extends BaseEntity{

    Integer score;
    String name;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: " + name + " | Score: " + score;
    }
}