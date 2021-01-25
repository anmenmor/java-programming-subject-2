package session1.term2.Exercise10;

public class Film {
    private String title;
    private int numberVotes;

    public Film(String title, int numberVotes){
        this.title = title;
        this.numberVotes = numberVotes;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberVotes() {
        return numberVotes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumberVotes(int numberVotes) {
        this.numberVotes = numberVotes;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", numberVotes=" + numberVotes +
                '}';
    }
}
