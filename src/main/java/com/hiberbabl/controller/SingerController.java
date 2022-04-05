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

    /**
     *  create singer
     * @param singer
     */
    @PostMapping
    public void createSinger(Singer singer) {
        singerService.save(singer);
    }

    /**
     * new singer
     * @param id
     * @return
     */
    @GetMapping
    public Singer getSinger(Long id) {
        return singerService.findById(id);
    }


    /**
     * update singer blabla
     * @param singer
     */
    @PutMapping
    public void update(Singer singer) {
        singerService.update(singer);
    }
}
