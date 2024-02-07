package com.example.Middleware02.Interceptors;

import com.example.Middleware02.FintoDB.FintoDB;
import com.example.Middleware02.Entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

public class MonthInterceptor implements HandlerInterceptor {

    @Autowired
    private FintoDB fintoDB;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");

        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        int requestedMonthNumber = Integer.parseInt(monthNumberHeader);
        Month requestedMonth = fintoDB.findMonth(requestedMonthNumber);

        if (requestedMonth != null) {
            request.setAttribute("requestedMonth", requestedMonth);
            }
            return true;
        }
    }


