package com.niit.C13S3CHRESTFULLEXCEPTION.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private String trackRating;
    private Artist trackArtist;

    public Track() {
    }

    public Track(int trackId, String trackName, String trackRating, Artist trackArtist) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackRating = trackRating;
        this.trackArtist = trackArtist;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackRating() {
        return trackRating;
    }

    public void setTrackRating(String trackRating) {
        this.trackRating = trackRating;
    }

    public Artist getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(Artist trackArtist) {
        this.trackArtist = trackArtist;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackRating='" + trackRating + '\'' +
                ", trackArtist=" + trackArtist +
                '}';
    }
}
