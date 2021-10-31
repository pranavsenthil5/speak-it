package com.startup_app.service;

import com.startup_app.domain.Pitch;
import com.startup_app.model.PitchDTO;
import com.startup_app.repos.PitchRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PitchService {

    private final PitchRepository pitchRepository;

    public PitchService(final PitchRepository pitchRepository) {
        this.pitchRepository = pitchRepository;
    }

    public List<PitchDTO> findAll() {
        return pitchRepository.findAll()
                .stream()
                .map(pitch -> mapToDTO(pitch, new PitchDTO()))
                .collect(Collectors.toList());
    }

    public PitchDTO get(final Long pitch) {
        return pitchRepository.findById(pitch)
                .map(eachPitch -> mapToDTO(eachPitch, new PitchDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final PitchDTO pitchDTO) {
        final Pitch pitch = new Pitch();
        mapToEntity(pitchDTO, pitch);
        return pitchRepository.save(pitch).getPitch();
    }

    public void update(final Long pitch, final PitchDTO pitchDTO) {
        final Pitch pitchObj = pitchRepository.findById(pitch)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(pitchDTO, pitchObj);
        pitchRepository.save(pitchObj);
    }

    public void delete(final Long pitch) {
        pitchRepository.deleteById(pitch);
    }

    private PitchDTO mapToDTO(final Pitch pitch, final PitchDTO pitchDTO) {
        pitchDTO.setPitch(pitch.getPitch());
        pitchDTO.setName(pitch.getName());
        pitchDTO.setDescription(pitch.getDescription());
        pitchDTO.setTagList(pitch.getTagList());
        return pitchDTO;
    }

    private Pitch mapToEntity(final PitchDTO pitchDTO, final Pitch pitch) {
        pitch.setName(pitchDTO.getName());
        pitch.setDescription(pitchDTO.getDescription());
        pitch.setTagList(pitchDTO.getTagList());
        return pitch;
    }

}
