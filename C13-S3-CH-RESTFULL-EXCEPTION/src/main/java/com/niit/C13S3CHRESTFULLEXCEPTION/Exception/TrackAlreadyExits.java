package com.niit.C13S3CHRESTFULLEXCEPTION.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Track Already Exits")
public class TrackAlreadyExits extends Exception {
}
