package com.niit.C13S3CHRESTFULLEXCEPTION.Service;

import com.niit.C13S3CHRESTFULLEXCEPTION.Domain.Track;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.ArtistNotFound;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.TrackAlreadyExits;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.TrackNotFound;
import com.niit.C13S3CHRESTFULLEXCEPTION.Repository.TrackRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService{
    TrackRepo trackRepo;

    public TrackServiceImpl(TrackRepo trackRepo) {
        this.trackRepo = trackRepo;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExits {
        if (trackRepo.findById(track.getTrackId()).isPresent()){
            throw new TrackAlreadyExits();
        }
        return trackRepo.save(track);
    }

    @Override
    public boolean deleteTrack(int id) throws TrackNotFound {
        boolean result =false;
        if (trackRepo.findById(id).isEmpty()){
            throw new TrackNotFound();
        }else {
          trackRepo.deleteById(id);
          result=true;
        }
        return result;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepo.findAll();
    }

    @Override
    public List<Track> getAllTrackByRatingGreaterThanFour() {
        return trackRepo.findAllTrackFromRating();
    }

    @Override
    public List<Track> getAllTrackByArtistName(String artistName) throws ArtistNotFound {
        if (trackRepo.findAllTrackFromArtist(artistName).isEmpty()){
            throw new ArtistNotFound();
        }
        return trackRepo.findAllTrackFromArtist(artistName);
    }
}
