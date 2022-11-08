package com.niit.C13S3CHRESTFULLEXCEPTION.Repository;

import com.niit.C13S3CHRESTFULLEXCEPTION.Domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrackRepo  extends MongoRepository<Track,Integer> {
    @Query("{'trackRating':{$gt:4}}")
    List<Track> findAllTrackFromRating();
    @Query("{'trackArtist':{$in:[?0]}}")
    List<Track> findAllTrackFromArtist(String artistName);
}
