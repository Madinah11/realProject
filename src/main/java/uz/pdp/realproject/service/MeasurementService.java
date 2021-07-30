package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.realproject.entity.Measurement;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result add( Measurement measurement){
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName)
            return new Result("There is such a unit of measurement",false);
        measurementRepository.save(measurement);
        return new Result("Measurement saved",true);
    }

    public List<Measurement> get(){
        List<Measurement> measurementList = measurementRepository.findAll();
        return measurementList;
    }

    public Measurement getById(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()){
            Measurement measurement = optionalMeasurement.get();
            return measurement;
        }
        return new Measurement();
    }

    public Result delete(Integer id){
       try {
           measurementRepository.deleteById(id);
           return new Result("Measurement deleted", true);
       }catch (Exception exception){
           return new Result("Measurement not found", false);
       }
    }

    public Result edit(Integer id,Measurement measurement){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("Measurement not found",false);
        Measurement editingMeasurement = optionalMeasurement.get();
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName)
            return new Result("There is such a unit of measurement",false);
        editingMeasurement.setName(measurement.getName());
        measurementRepository.save(editingMeasurement);
        return new Result("Measurement edited",true);



    }
}
