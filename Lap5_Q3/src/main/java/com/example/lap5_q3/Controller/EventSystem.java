package com.example.lap5_q3.Controller;

import com.example.lap5_q3.Model.Event;
import com.example.lap5_q3.Recaponse.Recaponse;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/////server port 1211

@RestController
@RequestMapping("api/v1/event")
public class EventSystem {

    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/display")
    public ArrayList<Event> display() {
        return events ;
    }
    @PostMapping("/add")
    public Recaponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new Recaponse("Added Event is successful");
    }
    @PutMapping("/update/{index}")
    public Recaponse updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new Recaponse("Updated Event is successful");
    }

    @DeleteMapping("/delete/{index}")
    public Recaponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new Recaponse("Deleted Event is successful");
    }

    @PutMapping("/change/{capacity}/{index}")
    public Recaponse changeCapacity(@PathVariable int capacity ,@PathVariable int index) {
        events.get(index).setCapacity(capacity);
        return new Recaponse("Updated capacity is successful");
    }

    @GetMapping("search/{id}")
    public ArrayList<Event> searchEvent(@PathVariable int id) {
        ArrayList<Event> events1 = new ArrayList<>();
        for (Event event : events) {
            if (event.getId() == id) {
                 events1.add(event);
            }
        }
        return events1;
    }





}
