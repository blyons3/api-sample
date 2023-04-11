package com.charter.rewards.service.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
@Data
public class PurchaseTransactions {
    List<PurchaseOrderHeader> transactions = new ArrayList<>();
}
