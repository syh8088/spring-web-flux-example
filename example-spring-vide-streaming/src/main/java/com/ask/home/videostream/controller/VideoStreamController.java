package com.ask.home.videostream.controller;

import com.ask.home.videostream.service.VideoStreamService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/video")
public class VideoStreamController {

    private final VideoStreamService videoStreamService;

    public VideoStreamController(VideoStreamService videoStreamService) {
        this.videoStreamService = videoStreamService;
    }

    @GetMapping("/stream/{fileType}/{fileName}")
    public Mono<ResponseEntity<byte[]>> streamVideo(ServerHttpResponse serverHttpResponse, @RequestHeader(value = "Range", required = false) String httpRangeList,
                                                    @PathVariable("fileType") String fileType,
                                                    @PathVariable("fileName") String fileName) {
        return Mono.just(videoStreamService.prepareContent(fileName, fileType, httpRangeList));
    }

    @GetMapping("/stream/v2/{fileType}/{fileName}")
    public Mono<ResponseEntity<byte[]>> streamVideoV2(ServerHttpResponse serverHttpResponse, @RequestHeader(value = "Range", required = false) String httpRangeList,
                                                    @PathVariable("fileType") String fileType,
                                                    @PathVariable("fileName") String fileName) {
        return Mono.just(videoStreamService.prepareContent(fileName, fileType, httpRangeList));
    }

    @GetMapping(value = "{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println(range);
        return videoStreamService.getVideo(title);
    }
}
