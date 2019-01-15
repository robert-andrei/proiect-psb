package com.banking.software.design.gymsubscription.service;

import com.banking.software.design.gymsubscription.model.*;
import com.banking.software.design.gymsubscription.model.dto.ClassDateDTO;
import com.banking.software.design.gymsubscription.model.dto.ViewBookingsDTO;
import com.banking.software.design.gymsubscription.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private LoginSessionRepository loginSessionRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity getAllClassnames(String username, String accessToken) {
        if (!sessionIsOk(username, accessToken)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        Optional<List<String>> classnames = classesRepository.getAllClassnames();

        if (!classnames.isPresent() || classnames.get().isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(classnames.get());
    }

    public ResponseEntity getClassesOnDate(String username, String accessToken, String date) {
        if (!sessionIsOk(username, accessToken)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        Optional<List<Timetable>> classesOnDate = timetableRepository.getClassesOnDate(date);

        if (!classesOnDate.isPresent() || classesOnDate.get().isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(classesOnDate.get().stream()
                .map(timetable -> new ClassDateDTO(timetable.getId(), timetable.getClassName(), timetable.getDateAndTime(), timetable.getDateAndTime())));
    }

    public ResponseEntity getDateForClass(String username, String accessToken, String classname) {
        if (!sessionIsOk(username, accessToken)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        Optional<List<Timetable>> classesOnDate = timetableRepository.getDateForClass(classname);

        if (!classesOnDate.isPresent() || classesOnDate.get().isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(classesOnDate.get().stream()
                .map(timetable -> new ClassDateDTO(timetable.getId(), timetable.getClassName(), timetable.getDateAndTime(), timetable.getDateAndTime())));
    }

    public ResponseEntity bookClass(String username, String accessToken, Long timetableId) {
//        Optional<List<Timetable>> classesOnDate = timetableRepository.getDateForClass(classname);

        if (!sessionIsOk(username, accessToken)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        Optional<Customer> customer = customerRepository.findById(username);
        Optional<Timetable> timetable = timetableRepository.findById(timetableId);
        if (!customer.isPresent() || !timetable.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        customer.get().addBooking(new Booking(customer.get(), timetable.get()));
        customerRepository.save(customer.get());

        return new ResponseEntity(HttpStatus.CREATED);
//        if (!classesOnDate.isPresent() || classesOnDate.get().isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.ok(classesOnDate.get().stream()
//                .map(timetable -> new DateForClassDTO(timetable.getId(), timetable.getDateAndTime(), timetable.getDateAndTime())));
    }

    public ResponseEntity getClassDetails(String username, String accessToken, String classname) {
        if (!sessionIsOk(username, accessToken)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        Optional<Classes> classes = classesRepository.findById(classname);

        if (!classes.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(classes.get());
    }

    public ResponseEntity getBookings(String username, String accessToken) {
        if (!username.equals("admin") || !sessionIsOk(username, accessToken)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        List<Booking> bookings = bookingRepository.findAll();

        if (bookings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bookings.stream().map(booking -> new ViewBookingsDTO(booking.getCustomer().getName(), booking.getTimetable().getClassName(),
                booking.getTimetable().getDateAndTime(), booking.getTimetable().getDateAndTime())));
    }

    private boolean sessionIsOk(String username, String accessToken) {
        Optional<LoginSession> loginSessionFromDb = loginSessionRepository.findById(username);

        return loginSessionFromDb.isPresent() && new BCryptPasswordEncoder().matches(accessToken, loginSessionFromDb.get().getToken());
    }
}
