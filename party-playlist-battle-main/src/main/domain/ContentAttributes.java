package com.party.playlist.battle.domain;




public class ContentAttributes {
    private String fileType;
    private String fileSize;
    private String title;
    private String artist;
    private String album;
    private String rating;
    private int length;
    private String path;



    public ContentAttributes(String fileType, String fileSize, String title, String artist, String album, String rating, int length, String path) {
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.rating = rating;
        this.length = length;
        this.path = path;
    }
}


