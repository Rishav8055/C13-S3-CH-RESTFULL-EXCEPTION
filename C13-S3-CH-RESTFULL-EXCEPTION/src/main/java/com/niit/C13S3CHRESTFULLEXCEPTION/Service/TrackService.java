package com.niit.C13S3CHRESTFULLEXCEPTION.Service;

import com.niit.C13S3CHRESTFULLEXCEPTION.Domain.Track;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.ArtistNotFound;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.TrackAlreadyExits;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.TrackNotFound;

import java.util.List;

public interface TrackService {
    Track saveTrack(Track track) throws TrackAlreadyExits;
    boolean deleteTrack(int id) throws TrackNotFound;
    List<Track> getAllTrack();
    List<Track> getAllTrackByRatingGreaterThanFour();
    List<Track> getAllTrackByArtistName(String artistName) throws ArtistNotFound;

}
