package findOponent;

public class Gamer implements  Comparable<Gamer> {

    private String nickname;
    private double rate;
    private Gamer oponent;
    private boolean ready;

    public Gamer(String nickname, double rate) {
        this.nickname = nickname;
        this.rate = rate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Gamer getOponent() {
        return oponent;
    }

    public void setOponent(Gamer oponent) {
        this.oponent = oponent;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gamer gamer = (Gamer) o;

        if (Double.compare(gamer.rate, rate) != 0) return false;
        return nickname != null ? nickname.equals(gamer.nickname) : gamer.nickname == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nickname != null ? nickname.hashCode() : 0;
        temp = Double.doubleToLongBits(rate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Gamer o) {
        return (int)Math.round(rate - o.getRate());
    }
}
