package com.banking.software.design.gymsubscription.controller;

import com.banking.software.design.gymsubscription.service.ClassesService;
import com.banking.software.design.gymsubscription.util.MappingPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(MappingPaths.CLASSES_PATH)
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @RequestMapping(value = MappingPaths.CLASSES_NAMES, method = RequestMethod.POST)
    public ResponseEntity getAllClassnames(@RequestParam("username") String username, @RequestParam("accessToken") String accessToken) {

        return classesService.getAllClassnames(username, accessToken);
    }

    @RequestMapping(value = MappingPaths.CLASSES_TIMETABLE, method = RequestMethod.POST)
    public ResponseEntity getClassesOnDate(@RequestParam("username") String username, @RequestParam("accessToken") String accessToken,
            @RequestParam("date") String date) {

        if (!date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return ResponseEntity.badRequest().body("Invalid date format!");
        }

        return classesService.getClassesOnDate(username, accessToken, date);
    }

    @RequestMapping(value = MappingPaths.CLASSES_DATE, method = RequestMethod.POST)
    public ResponseEntity getDateForClass(@RequestParam("username") String username, @RequestParam("accessToken") String accessToken,
            @RequestParam("name") String classname) {

        return classesService.getDateForClass(username, accessToken, classname);
    }

    @RequestMapping(value = MappingPaths.CLASSES_BOOK, method = RequestMethod.POST)
    public ResponseEntity bookClass(@RequestParam("username") String username, @RequestParam("accessToken") String accessToken, @RequestParam("id") Long id) {

        return classesService.bookClass(username, accessToken, id);
    }

    @RequestMapping(value = MappingPaths.CLASSES_DETAILS, method = RequestMethod.POST)
    public ResponseEntity getClassDetails(@RequestParam("username") String username, @RequestParam("accessToken") String accessToken, @RequestParam("name") String classname) {

        return classesService.getClassDetails(username, accessToken, classname);
    }

    @RequestMapping(value = MappingPaths.CLASSES_BOOKINGS, method = RequestMethod.POST)
    public ResponseEntity getBookings(@RequestParam("username") String username, @RequestParam("accessToken") String accessToken) {

        return classesService.getBookings(username, accessToken);
    }
}
