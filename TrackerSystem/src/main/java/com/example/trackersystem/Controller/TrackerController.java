package com.example.trackersystem.Controller;

import com.example.trackersystem.Model.Tracker;
import com.example.trackersystem.Recaponse.Recaponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerController {

    ///server port 1213

    ArrayList<Tracker> trackers = new ArrayList<>();

    @PostMapping("/add")
    public Recaponse addTracker(@RequestBody Tracker tracker){

        trackers.add(tracker);
        return new Recaponse(" Added Tracker successfully ");
    }
    @GetMapping("/display")
    public ArrayList<Tracker> getTrackers(){
        return trackers;
    }
    @PutMapping("/update/{index}")
    public Recaponse updateTracker(@RequestBody Tracker tracker , @PathVariable int index){
        trackers.set(index, tracker);
        return new Recaponse(" Updated Tracker successfully ");
    }

    @DeleteMapping("/delete/{index}")
    public Recaponse deleteTracker(@PathVariable int index){
        trackers.remove(index);
        return new Recaponse(" Deleted Tracker successfully ");
    }

    @PutMapping("/change/{index}")
    public String changeStatus(@PathVariable int index){
        if(trackers.get(index).getStatus().equals("not done")){
            trackers.get(index).setStatus("done");
            return "Tracker status is now done";
        }else
            trackers.get(index).setStatus("done");
        return "Tracker status is already done";
    }

    @GetMapping("/search/{title}")
    public ArrayList<Tracker> searchTitle(@PathVariable String title){
        ArrayList<Tracker> trackers1 = new ArrayList<>();
        for(Tracker tracker : trackers){
            if(tracker.getTitle().equals(title)){
                trackers1.add(tracker);
            }
        }
        return trackers1;
    }

    @GetMapping("getCompanyName/{companyName}")
    public ArrayList<Tracker> getTrackersByCompanyName(@PathVariable String companyName){
        ArrayList<Tracker> trackers1 = new ArrayList<>();
        for(Tracker tracker : trackers){
            if(tracker.getCompanyName().equals(companyName)){
                trackers1.add(tracker);
            }

        }
        return trackers1;

    }





}
