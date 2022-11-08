package com.example.poll.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.poll.dao.PollDao;
import com.example.poll.dto.PollDto;
import com.example.poll.model.Poll;

@ExtendWith(MockitoExtension.class)
public class PollServiceTest {
    @Mock
    private PollDao pollDao;

    @InjectMocks
    private PollServiceImpl pollServiceImpl;

    @Test
    public void whenSavePoll_shouldReturnPoll() {
        Poll poll = new Poll("nicolas.alvarez@usach.cl",1L);
        PollDto pollDto = new PollDto("nicolas.alvarez@usach.cl",1L);

        when(pollDao.save(ArgumentMatchers.any(Poll.class))).thenReturn(poll);

        Poll created = pollServiceImpl.save(pollDto);

        assertThat(created.getEmail()).isSameAs(poll.getEmail());
        verify(pollDao).save(poll);
    }

    @Test
    public void shouldReturnAllPolls() {
        List<Poll> pollList = new ArrayList<Poll>();
        pollList.add(new Poll("nicolas.alvarezc@usach.cl",1L));

        given(pollDao.findAll()).willReturn(pollList);

        List<Poll> expected = pollServiceImpl.findAll();

        assertEquals(expected, pollList);
        verify(pollDao).findAll();
    }
}
