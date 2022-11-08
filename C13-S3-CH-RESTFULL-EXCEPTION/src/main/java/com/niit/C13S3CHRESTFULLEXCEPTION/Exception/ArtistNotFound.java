package com.niit.C13S3CHRESTFULLEXCEPTION.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "Artist Not found")
public class ArtistNotFound  extends Exception{
}
