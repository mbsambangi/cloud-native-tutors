package com.cloudnative.domain.guardian;

import com.cloudnative.domain.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by msambangi on 10/26/17.
 */

@Service
public class GuardianService {

    @Autowired
    private GuardianRepository guardianRepository;

    public Optional<Guardian> createGuardian(Guardian guardian) {
        Account account = new Account(guardian.getEmail());
        Guardian guardian1 = new Guardian(guardian.getFirstName(), guardian.getLastName(), guardian.getEmail(), guardian.getPhoneNumber(), account);
        return Optional.of(guardianRepository.save(guardian1));
    }
}
