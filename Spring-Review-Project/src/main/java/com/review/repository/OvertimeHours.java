package com.review.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("overtimeHours")
public class OvertimeHours implements HoursRepository{
    @Override
    public int getHours() {
        return 15;
    }
}
