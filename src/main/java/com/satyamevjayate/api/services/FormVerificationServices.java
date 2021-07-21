package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.entity.FormVerfication;
import com.satyamevjayate.api.entity.Police;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.repo.ComplainerRepository;
import com.satyamevjayate.api.repo.FormVerificationRepository;
import com.satyamevjayate.api.repo.PoliceRepository;
import com.satyamevjayate.api.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.math.BigInteger;
import java.util.List;
@Service
public class FormVerificationServices {
    @Autowired
    private FormVerificationRepository formVerificationRepository;
    @Autowired
    private ComplainerRepository complainerRepository;

    @Autowired
    private PoliceRepository policeRepository;

    @Autowired
    private WorkerRepository workerRepository;

   public List<FormVerfication> listformverfication(){ return formVerificationRepository.findAll(); }

    public FormVerfication saveFormVerfication(FormVerfication formVerfication){

       complainerRepository.save(formVerfication.getComplainerName());
        policeRepository.save(formVerfication.getPoliceName());
        workerRepository.save(formVerfication.getWorkerName());
        return formVerificationRepository.save(formVerfication);
    }

    public FormVerfication editFormVerfication(FormVerfication formVerfication){

        Complainer complainer = complainerRepository.findById(formVerfication.getComplainerName().getComplainerID()).orElse(null);
        if(null==complainer){
            complainer=new Complainer();
        }
        complainer.setComplainerName(formVerfication.getComplainerName().getComplainerName());
        complainer.setComplainerContact(formVerfication.getComplainerName().getComplainerContact());
        complainer.setComplainerPerson(formVerfication.getComplainerName().getComplainerPerson());
        complainer.setComplainerPermanentAddress(formVerfication.getComplainerName().getComplainerPermanentAddress());
        complainer.setComplainerResidenceAddress(formVerfication.getComplainerName().getComplainerResidenceAddress());
        complainer.setPwd(formVerfication.getComplainerName().getPwd());
        formVerfication.setComplainerName(complainer);

        Police police = policeRepository.findById(formVerfication.getPoliceName().getPoliceID()).orElse(null);
        if(null==police){
            police=new Police();
        }
        police.setPoliceStationID(formVerfication.getPoliceName().getPoliceStationID());
        police.setPoliceRoleID(formVerfication.getPoliceName().getPoliceRoleID());
        police.setPerson(formVerfication.getPoliceName().getPerson());
        police.setPoliceContact(formVerfication.getPoliceName().getPoliceContact());
        police.setPolicePermanentAddress(formVerfication.getPoliceName().getPolicePermanentAddress());
        police.setPoliceResidenceAddress(formVerfication.getPoliceName().getPolicePermanentAddress());
        police.setPwd(formVerfication.getPoliceName().getPwd());
        police.setPoliceCardImage(formVerfication.getPoliceName().getPoliceCardImage());
        formVerfication.setPoliceName(police);

        Worker worker = workerRepository.findById(formVerfication.getWorkerName().getWorkerID()).orElse(null);
        if(null==worker){
            worker=new Worker();
        }
        worker.setWorkerID(formVerfication.getWorkerName().getWorkerID());
        worker.setWorkerContact(formVerfication.getWorkerName().getWorkerContact());
        worker.setWorkerPerson(formVerfication.getWorkerName().getWorkerPerson());
        worker.setWorkerPermanentAddress(formVerfication.getWorkerName().getWorkerPermanentAddress());
        worker.setWorkerResidenceAddress(formVerfication.getWorkerName().getWorkerResidenceAddress());
        worker.setDateOfJoining(formVerfication.getWorkerName().getDateOfJoining());
        worker.setDateOfResign(formVerfication.getWorkerName().getDateOfResign());
        formVerfication.setWorkerName(worker);

        return formVerificationRepository.save(formVerfication);


    }

    public FormVerfication getFormVefication(Long id){return formVerificationRepository.findById(id).get();}

    public void deleteFromVerfication(Long id){formVerificationRepository.deleteById(id);}




}
