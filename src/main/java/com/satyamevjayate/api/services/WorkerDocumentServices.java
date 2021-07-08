package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.entity.WorkerDocument;
import com.satyamevjayate.api.repo.WorkerDocumentRepository;
import com.satyamevjayate.api.repo.WorkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class WorkerDocumentServices {
    @Autowired
    private WorkerDocumentRepository workerDocumentRepository;

    @Autowired
    private WorkerRepository workerRepository;
    
    public List<WorkerDocument> listAllWorkerDocument()
    {
        return workerDocumentRepository.findAll();
    }

    public WorkerDocument saveWorkerDocument(WorkerDocument WorkerDocument)
    {
//    	Worker worker = Worker_repo.findById(WorkerDocument.getWorkerdoc().getWorkerID()).orElse(null);
//        if (null == worker) {
        Worker worker = new Worker();
//        }
        worker.setWorkerID(WorkerDocument.getWorkerDocument().getWorkerID());
        workerRepository.save(worker);
        WorkerDocument.setWorkerDocument(worker);
       return workerDocumentRepository.save(WorkerDocument);
    }

    public WorkerDocument getWorkerDocument(Long Id)
    {
        return workerDocumentRepository.findById(Id).get();
    }

    public void deleteWorkerDocument(Long Id)
    {
        workerDocumentRepository.deleteById(Id);
    }
}
