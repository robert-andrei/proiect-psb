package com.banking.software.design.gymsubscription.service;

import com.banking.software.design.gymsubscription.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;
}
