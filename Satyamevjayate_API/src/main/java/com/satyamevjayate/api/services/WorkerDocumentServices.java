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
    private WorkerDocumentRepository WorkerDocument_repo;

    @Autowired
    private WorkerRepository Worker_repo;
    
    public List<WorkerDocument> listAllWorkerDocument()
    {
        return WorkerDocument_repo.findAll();
    }

    public WorkerDocument saveWorkerDocument(WorkerDocument WorkerDocument)
    {
//    	Worker worker = Worker_repo.findById(WorkerDocument.getWorkerdoc().getWorkerID()).orElse(null);
//        if (null == worker) {
        Worker worker = new Worker();
//        }
        worker.setWorkerID(WorkerDocument.getWorkerDocument().getWorkerID());
        Worker_repo.save(worker);
        WorkerDocument.setWorkerDocument(worker);
       return WorkerDocument_repo.save(WorkerDocument);
    }

    public WorkerDocument getWorkerDocument(Long Id)
    {
        return WorkerDocument_repo.findById(Id).get();
    }

    public void deleteWorkerDocument(Long Id)
    {
        WorkerDocument_repo.deleteById(Id);
    }
}
