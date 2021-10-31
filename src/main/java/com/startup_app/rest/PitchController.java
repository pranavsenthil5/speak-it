package com.startup_app.rest;

import com.startup_app.model.PitchDTO;
import com.startup_app.service.PitchService;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/pitchs", produces = MediaType.APPLICATION_JSON_VALUE)
public class PitchController {

    private final PitchService pitchService;

    public PitchController(final PitchService pitchService) {
        this.pitchService = pitchService;
    }

    @GetMapping
    public ResponseEntity<List<PitchDTO>> getAllPitchs() {
        return ResponseEntity.ok(pitchService.findAll());
    }

    @GetMapping("/{pitch}")
    public ResponseEntity<PitchDTO> getPitch(@PathVariable final Long pitch) {
        return ResponseEntity.ok(pitchService.get(pitch));
    }

    @PostMapping
    public ResponseEntity<Long> createPitch(@RequestBody @Valid final PitchDTO pitchDTO) {
        return new ResponseEntity<>(pitchService.create(pitchDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{pitch}")
    public ResponseEntity<Void> updatePitch(@PathVariable final Long pitch,
            @RequestBody @Valid final PitchDTO pitchDTO) {
        pitchService.update(pitch, pitchDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{pitch}")
    public ResponseEntity<Void> deletePitch(@PathVariable final Long pitch) {
        pitchService.delete(pitch);
        return ResponseEntity.noContent().build();
    }

}
