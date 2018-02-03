package models;

public class Notes {
    private Long twenty;
    private Long fifty;
    private Long hundred;
    private Long fiveHundred;
    private Long thousand;

    public Notes(Long twenty, Long fifty, Long hundred, Long fiveHundred, Long thousand) {
        this.twenty = twenty;
        this.fifty = fifty;
        this.hundred = hundred;
        this.fiveHundred = fiveHundred;
        this.thousand = thousand;
    }

    public Long getFifty() {
        return fifty;
    }

    public void setFifty(Long fifty) {
        fifty = fifty;
    }

    public Long getFiveHundred() {
        return fiveHundred;
    }

    public void setFiveHundred(Long fiveHundred) {
        fiveHundred = fiveHundred;
    }

    public Long getHundred() {
        return hundred;
    }

    public void setHundred(Long hundred) {
        hundred = hundred;
    }

    public Long getThousand() {
        return thousand;
    }

    public void setThousand(Long thousand) {
        thousand = thousand;
    }

    public Long getTwenty() {
        return twenty;
    }

    public void setTwenty(Long twenty) {
        twenty = twenty;
    }
}