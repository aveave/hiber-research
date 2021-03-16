package com.hiberbabl.controller;

import com.hiberbabl.entity.Singer;
import com.hiberbabl.service.SingerService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/singer")
public class SingerController {

    private final SingerService singerService;

    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    @PostMapping
    public void createSinger(Singer singer) {
        singerService.save(singer);
    }

    @GetMapping
    public Singer getSinger(Long id) {
        return singerService.findById(id);
    }

    @PutMapping
    public void update(Singer singer) {
        singerService.update(singer);
    }
}
