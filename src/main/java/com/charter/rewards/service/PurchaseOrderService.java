package com.charter.rewards.service;

import com.charter.rewards.service.domain.PurchaseOrderHeader;
import com.charter.rewards.service.domain.PurchaseTransactions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {

    @Autowired
    private final PurchaseTransactions purchaseTransactions;

    // Currently using transactions loaded from the bootstrap configuration, this would
    // probably be replaced with Repositories defined for the persistent store in use:
    // Mongo, Oracle, etc.
    public PurchaseOrderHeader getPoById(long transactionId){

        for(PurchaseOrderHeader r : purchaseTransactions.getTransactions()){
            if( r.getTransactionID() == transactionId){
                return r;
            }
        }

        return null;
    }

    public List<PurchaseOrderHeader> getAllPoHeaders(){

        return Collections.unmodifiableList(purchaseTransactions.getTransactions());
    }

    public List<PurchaseOrderHeader> getAllPoHeadersByCustomer(long customerId){

        List<PurchaseOrderHeader> allCustomerTransactions = new ArrayList<>();
        for(PurchaseOrderHeader p: purchaseTransactions.getTransactions()){
            if( p.getCustomerId() == customerId ){
                allCustomerTransactions.add(p);
            }
        }
        return allCustomerTransactions;
    }
}
