package nl.bioinf.jpro_pkam.grappaweb.Grappa;

public class matchGroup {
    private Character start;
    private Character end;

    public matchGroup(Character start, Character end) {
        this.start = start;
        this.end = end;
    }

    public Character getStart() {
        return this.start;
    }

    public Character getEnd() {
        return this.end;
    }

    public String findMatch(String string) {
        return "";
    }
}