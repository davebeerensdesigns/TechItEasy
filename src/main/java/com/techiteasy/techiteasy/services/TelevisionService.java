package com.techiteasy.techiteasy.services;

import com.techiteasy.techiteasy.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelevisionService {

    @Autowired
    private TelevisionRepository televisionRepository;

}
