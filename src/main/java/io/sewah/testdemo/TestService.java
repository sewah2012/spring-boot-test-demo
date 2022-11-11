package io.sewah.testdemo;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public Boolean checkEvenNumber(Integer number) {
        if(number == 0) return false;
        return number % 2 == 0;
    }
}
