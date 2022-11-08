package com.niit.C13S3CHRESTFULLEXCEPTION.Controller;

import com.niit.C13S3CHRESTFULLEXCEPTION.Domain.Track;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.ArtistNotFound;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.TrackAlreadyExits;
import com.niit.C13S3CHRESTFULLEXCEPTION.Exception.TrackNotFound;
import com.niit.C13S3CHRESTFULLEXCEPTION.Service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/track/api")
public class TrackController {
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> insertTrack(@RequestBody Track track) throws TrackAlreadyExits {
        ResponseEntity responseEntity = null;

        try {
            responseEntity = new ResponseEntity<>(trackService.saveTrack(track), HttpStatus.CREATED);
        } catch (TrackAlreadyExits e) {
            throw new TrackAlreadyExits();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @GetMapping("/get")
    public ResponseEntity<?> fetchAllTrack() {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(trackService.getAllTrack(), HttpStatus.OK);

        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/delete/{trackId}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int trackId) throws TrackNotFound {
        ResponseEntity responseEntity = null;
        try {
            trackService.deleteTrack(trackId);
            responseEntity = new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        } catch (TrackNotFound e) {
            throw new TrackNotFound();
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return responseEntity;
    }
    @GetMapping("/trackFour")
    public ResponseEntity<?> fetchTrackGreaterThanFourRating(){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity(trackService.getAllTrackByRatingGreaterThanFour(),HttpStatus.FOUND);

        } catch (Exception e) {
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
    @GetMapping(value = "/track/{artistName}")
    public ResponseEntity<?> getAllTracksByArtistName(@PathVariable String artistName) throws ArtistNotFound {
        ResponseEntity responseEntity = null;
        try{
            responseEntity = new ResponseEntity(trackService.getAllTrackByArtistName(artistName),HttpStatus.FOUND);
        }catch( ArtistNotFound e){
            throw new ArtistNotFound();
        }catch(Exception e){
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
