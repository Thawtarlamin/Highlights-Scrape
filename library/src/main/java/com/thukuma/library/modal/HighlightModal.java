package com.thukuma.library.modal;

public class HighlightModal {
    private String title,image,league,date,href;

    public HighlightModal(String title, String image, String league, String date, String href) {
        this.title = title;
        this.image = image;
        this.league = league;
        this.date = date;
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getLeague() {
        return league;
    }

    public String getDate() {
        return date;
    }

    public String getHref() {
        return href;
    }
}
