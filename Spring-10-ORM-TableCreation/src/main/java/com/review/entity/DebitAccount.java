package com.review.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "debitAccounts")
public class DebitAccount extends Account
{
    private BigDecimal overDraftFee;
}
